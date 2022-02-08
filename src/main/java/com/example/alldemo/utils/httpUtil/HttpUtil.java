package com.example.alldemo.utils.httpUtil;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @Description http请求类
 */
@Slf4j
public class HttpUtil {

    public static String request(String method, String authKey, String apiUrl, Map<String, Object> params) {
        try {

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("x-log-signaturemethod", "hmac-sha1");
            if (StringUtils.isNotEmpty(authKey)) {
                connection.setRequestProperty("Authorization", authKey);
            }

            connection.connect();

            if (params != null && params.size() > 0) {
                byte[] content = JSON.toJSONString(params).getBytes(StandardCharsets.UTF_8);
                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.write(content);
                out.flush();
                out.close();
            }

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer response = new StringBuffer();

            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), StandardCharsets.UTF_8);
                response.append(lines);
            }
            reader.close();
            connection.disconnect();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String post(String authKey, String apiUrl, Map<String, Object> params) {
        String method = "POST";
        return request(method, authKey, apiUrl, params);
    }

    public static String get(String authKey, String apiUrl, Map<String, Object> params) {
        String method = "GET";
        return request(method, authKey, apiUrl, params);
    }

    public static String get(String apiUrl, Map<String, Object> params) {
        String method = "GET";
        return request(method, null, apiUrl, params);
    }

    public static void main(String args[]) {

        try {
            String resp = get("https://www.baidu.com",null);
            System.out.println("resp: " + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
