package org.lk.springboot.demo.service.weixin;

public enum  WeiXinUrlEnum {
    /**
     * 需要参数
     * appid
     * appsecret
     * **/
    ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%1$s&secret=%2$s"),

    ;

    WeiXinUrlEnum(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl(String ...value) {
        return String.format(this.url, value);
    }
}
