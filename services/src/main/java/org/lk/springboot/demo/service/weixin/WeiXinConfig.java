package org.lk.springboot.demo.service.weixin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

@Configuration
public class WeiXinConfig {
    public static final String TOKEN = "java_sun_oracle_luokai_2017";
    public static final String APP_ID = "wx13793d9542af234b";
    public static final String APP_SECRET = "13b6a0df1bc82edc6c0c7f14b87c5cf3";
    
    @Bean
    @Autowired
    public WxMpService wxMpService(WxMpInMemoryConfigStorage config) {
    	WxMpService wxMpService = new WxMpServiceImpl();
    	wxMpService.setWxMpConfigStorage(config);
    	return wxMpService;
    }
    
    @Bean
    public WxMpInMemoryConfigStorage WxMpInMemoryConfigStorage() {
    	WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
    	wxMpInMemoryConfigStorage.setAppId(APP_ID);
    	wxMpInMemoryConfigStorage.setSecret(APP_SECRET); // 设置微信公众号的app corpSecret
    	wxMpInMemoryConfigStorage.setToken(""); // 设置微信公众号的token
    	wxMpInMemoryConfigStorage.setAesKey(""); // 设置微信公众号的EncodingAESKey
    	return wxMpInMemoryConfigStorage;
    }
}
