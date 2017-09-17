package org.lk.springboot.demo.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.lk.springboot.demo.service.baidu.BaiduMapConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class HttpClientHelper {
    private PoolingHttpClientConnectionManager cm ;

    private CloseableHttpClient httpClient;
    @PostConstruct
    private void init(){
        if (cm == null){
            cm = new PoolingHttpClientConnectionManager();
        }
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
        HttpHost localhost = new HttpHost("localhost", 80);
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);
        httpClient = HttpClients.custom().setConnectionManager(cm).build();
    }

    public String post(String url, String content) {
        HttpPost httpPost = new HttpPost(url);
        if (StringUtils.isNotEmpty(content)){
            try {
                httpPost.setEntity(new StringEntity(content));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            InputStream resp = entity.getContent();
            return StringUtils.join(IOUtils.readLines(resp,"utf-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //cm.releaseConnection(httpClient, null, 1, TimeUnit.MINUTES);
    }

    public String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            InputStream resp = entity.getContent();
            return StringUtils.join(IOUtils.readLines(resp,"utf-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //cm.releaseConnection(httpClient, null, 1, TimeUnit.MINUTES);
    }

    // 对Map内所有value作utf8编码，拼接返回结果
    public String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        for (Map.Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey() + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue(),
                    "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        HttpClientHelper httpClientHelper = new HttpClientHelper();
        httpClientHelper.init();
        String resp = httpClientHelper.post(BaiduMapConfig.getAddressUrl("183.11.69.175"), null);
        System.out.println(resp);
        resp = StringEscapeUtils.unescapeJava(resp);
        System.out.println(resp);
    }

}
