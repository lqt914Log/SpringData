package com.lqt.httptest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 测试返回值
 *
 * @author lqt77
 * @date 2019-06-24-11:02
 */
public class ResponseController {
    public  static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://192.168.2.86:9091/auth/login?username=15801408389&password=Abcd1234");
        CloseableHttpResponse responseBody = httpclient.execute(httpGet);
        try {
            System.out.println(responseBody.getStatusLine().getStatusCode());
            HttpEntity entity = responseBody.getEntity();
            System.out.println(entity);
            String entityStr = entity.getContent().toString();
            System.out.println(entityStr);
            System.out.println(entity.getContent().read());
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity);
        } finally {
            responseBody.close();
        }
    }

    /**
     * 不含参数的doGet方法
     */
    public void doGet(){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://192.168.2.86:9091/auth/login?username=15801408389&password=Abcd1234");
        CloseableHttpResponse responseBody = null;
        try {
            responseBody = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(responseBody.getStatusLine());
            HttpEntity entity1 = responseBody.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            try {
                EntityUtils.consume(entity1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                responseBody.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
