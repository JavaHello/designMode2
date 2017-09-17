package org.lk.springboot.demo.service.tuling;

import org.lk.springboot.demo.util.HttpClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuLingHttpHelper {


    @Autowired
    private HttpClientHelper httpClientHelper;

    public String sendMessage(String content,String userId){
        TuLingRequestObj bulid = TuLingRequestObj.invoke().setInfo(content).setUserid(userId).bulid();
        return httpClientHelper.post(TuLingConfig.API_URL, bulid.sing(TuLingConfig.SECRET));
    }

    public String sendMessage(String content){
        return this.sendMessage(content, null);
    }

    public static void main(String[] args) {
        String message = new TuLingHttpHelper().sendMessage("交个朋友");
        System.out.println(message);
    }
}
