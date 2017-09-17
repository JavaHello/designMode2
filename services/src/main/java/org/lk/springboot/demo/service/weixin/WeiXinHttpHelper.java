package org.lk.springboot.demo.service.weixin;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.lk.springboot.demo.util.HttpClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeiXinHttpHelper {

    @Autowired
    private HttpClientHelper httpClientHelper;

    public String getAccessToken(String appid, String appsecret) throws IOException {
        return httpClientHelper.post(WeiXinUrlEnum.ACCESS_TOKEN.getUrl(appid, appsecret), null);
    }


    public static void main(String[] args) throws IOException {
        String accessToken = new WeiXinHttpHelper().getAccessToken(WeiXinConfig.APP_ID, WeiXinConfig.APP_SECRET);
        System.out.println(accessToken);
    }
}
