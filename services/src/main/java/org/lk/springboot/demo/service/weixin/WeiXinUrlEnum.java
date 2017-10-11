package org.lk.springboot.demo.service.weixin;

public enum  WeiXinUrlEnum {
    /**
     * 需要参数
     * appid
     * appsecret
     * **/
    ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%1$s&secret=%2$s"),
    /**
     * 需要参数
     * appid
     * appsecret
     * code
     * **/
    AUTH_ACCESS_TOKEN("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%1$s&secret=%2$s&code=%3$s&grant_type=authorization_code"),

    /**
     * 需要参数
     * access_toke
     * openId
     * **/
    GET_USER_INFO("https://api.weixin.qq.com/sns/userinfo?access_token=%1$s&openid=%2$s&lang=zh_CN "),
    ;

    WeiXinUrlEnum(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl(String ...value) {
        return String.format(this.url, value);
    }
}
