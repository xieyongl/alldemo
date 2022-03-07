package com.example.alldemo.utils.img;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/3/3 16:15
 **/
public class DownloadImgUtil {

    public static void main(String[] args) {
        //1.获取所有数据链接（也可以分批次）
//        CaseLibraryDTO caseLibraryDTO = new CaseLibraryDTO();
//        List<CaseCardVO> cardList = caseCardMapper.getCaseCrad(caseLibraryDTO);
        List cardList = new ArrayList<>();
        cardList.forEach(caseCardVO -> {

            //网络图片链接地址
//            String webURL = caseCardVO.getCardUrl();
            String webURL = "sssss";
            //本地保存地址
            String localPath = "D:\\tmp\\img\\" + Math.random() + ".jpg";

            try {
                //网络URL
                URL url = new URL(webURL);
                //打开网络连接
                URLConnection connection = url.openConnection();
                //输入流
                InputStream inputStream = connection.getInputStream();
                //输出文件流
                OutputStream outputStream = new FileOutputStream(new File(localPath));
                //缓冲区对象
                byte[] b = new byte[1024];
                //读取计数器
                int len;
                while ((len = inputStream.read(b)) != -1) {
                    outputStream.write(b, 0, len);
                }
                //关闭输入流操作
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //关闭输出流操作
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //监听下载成功
            } catch (
                    Exception e) {
                //监听下载失败
                e.printStackTrace();
            }
        });


    }


}