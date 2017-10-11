package org.lk.springboot.demo.service.weixin;

import java.io.IOException;

import org.lk.springboot.demo.util.HttpClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class WeiXinHttpHelper {

    @Autowired
    private HttpClientHelper httpClientHelper;

    public String getAccessToken(String appid, String appsecret) throws IOException {
        return httpClientHelper.post(WeiXinUrlEnum.ACCESS_TOKEN.getUrl(appid, appsecret), null);
    }
    
    public JSONObject getAuthAccessToken(String appid, String appsecret, String code) throws IOException {
        return JSONObject.parseObject(httpClientHelper.get(WeiXinUrlEnum.AUTH_ACCESS_TOKEN.getUrl(appid, appsecret, code)));
    }
    
    public JSONObject getUserInfo(String accessToken, String openId) throws IOException {
        return JSONObject.parseObject(httpClientHelper.get(WeiXinUrlEnum.GET_USER_INFO.getUrl(accessToken, openId)));
    }
}
