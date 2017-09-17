package org.lk.springboot.demo.service.baidu;

import org.apache.commons.lang3.StringEscapeUtils;
import org.lk.springboot.demo.util.HttpClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaiduMapHelper {

    @Autowired
    private HttpClientHelper httpClientHelper;

    public String getAddressByIP(String ip){
        return StringEscapeUtils.unescapeJava(httpClientHelper.get(BaiduMapConfig.getAddressUrl(ip)));
    }
}
