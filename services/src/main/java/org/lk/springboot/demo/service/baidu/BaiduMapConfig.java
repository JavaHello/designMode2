package org.lk.springboot.demo.service.baidu;

public class BaiduMapConfig {
    public static final String DOMAIN = "http://api.map.baidu.com/location/ip?";
    public static final String AK = "VaftUTYOK4h58GaLGaQK2FKDxrHMQonn";

    public static String getAddressUrl(String ip){
        return DOMAIN + "ak=" + AK + "&ip=" + ip;
    }
}
