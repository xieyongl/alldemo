package com.example.alldemo.utils.qiniuyun.util;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

/**
 * 七牛云
 * 各操作调用
 *
 */
@Component
@Slf4j
public class QiNiuUtils {
	@Value("${qiniu.file.accessKey}")
	private String accessKey;
	@Value("${qiniu.file.secretKey}")
	private String secretKey;
	@Value("${qiniu.file.bucket}")
	private String bucket;
	@Value("${qiniu.file.cdnUrl}")
	private String cdnUrl;

	/**
	 * 本地上传文件
	 * @param file
	 * @param dir 用户上传文件时指定的文件夹。
	 */
	public  String uploadFile(File file,String dir) throws QiniuException {
		//构造一个带指定 Region 对象的配置类
		Configuration cfg = new Configuration(Region.autoRegion());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String fileName = file.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		String key = preHandle(UUID.randomUUID()+ "." + suffix, dir);
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		Response response = uploadManager.put(file, key, upToken);
		return getUrlPath(response);
	}

	public  String uploadFile(byte[] bytes,String fileName) throws QiniuException {
		//构造一个带指定 Region 对象的配置类
		Configuration cfg = new Configuration(Region.autoRegion());

		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);

		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		try {
			Response response = uploadManager.put(bytes, fileName, upToken);
			//解析上传成功的结果
			return getUrlPath(response);
		} catch (QiniuException ex) {
			Response r = ex.response;
			log.error("【图片上传】" +r.toString());
		}
		return null;
	}

	private  String preHandle(String fileName, String dir) {
		if (StrUtil.isNotBlank(dir) && !dir.startsWith("/")) {
			dir = "/" + dir;
		}
		String name = StrUtil.isBlank(fileName) ? RandomUtil.randomString(32) : fileName;
		if (StrUtil.isBlank(dir)) {
			return name;
		}
		String prefix = dir.replaceFirst("/", "");
		return (prefix.endsWith("/") ? prefix : prefix.concat("/")).concat(name);
	}

	/**
	 * 获取自定义文件名
	 */
	public String preCustom(MultipartFile imgFile, String dir) {
		if (imgFile == null) {
			throw new NullPointerException("文件为空");
		}
		// 获取文件的原始名称
		String originalFilename = imgFile.getOriginalFilename();
		if (StringUtils.isEmpty(originalFilename)) {
			originalFilename = UUID.randomUUID().toString();
		}
		// 拿到后缀名
		String sub = originalFilename.substring(originalFilename.lastIndexOf("."));
		// 拿到UUID
		String uuid = UUID.randomUUID().toString();
		// 文件的最终名称
		String fileName = uuid + sub;
		return preHandle(fileName, dir);
	}

	public String preCustom(){
		// 拿到UUID
		String fileName = UUID.randomUUID().toString()+".jpg";
		return preHandle(fileName, "community/center/");
	}

	private  String getUrlPath(Response response) throws QiniuException {
		DefaultPutRet putRet = JSONUtil.toBean(response.bodyString(), DefaultPutRet.class);
		String key = putRet.key;
		return "http://" + cdnUrl + (key.startsWith("/") ? key : "/" + key);
	}

	public  String uploadFile(InputStream inputStream) throws QiniuException {
		String uuid = UUID.randomUUID().toString()+".jpg";
		String fileName = preHandle(uuid, "community/center/");

		//构造一个带指定 Region 对象的配置类
		Configuration cfg = new Configuration(Region.autoRegion());

		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);

		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		try {
			Response response = uploadManager.put(inputStream, fileName, upToken,null,null);
			//解析上传成功的结果
			return getUrlPath(response);
		} catch (QiniuException ex) {
			Response r = ex.response;
			log.error("【图片上传】" +r.toString());
		}
		return null;
	}
}
