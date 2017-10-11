package org.lk.springboot.demo.service.weixin;

import java.io.IOException;

import org.lk.springboot.demo.util.HttpClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
