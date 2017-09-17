package org.lk.springboot.demo.service.tuling;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

public class TuLingRequestObj {

    private String key;
    private String info;
    private String loc;
    private String userid;

    public TuLingRequestObj(String key, String info, String loc, String userid) {
        this.key = key;
        this.info = info;
        this.loc = loc;
        this.userid = userid;
    }

     static class Bulider{
        private String key;
        private String info;
        private String loc;
        private String userid;



        public String getKey() {
            return key;
        }

        public Bulider setKey(String key) {
            this.key = key;
            return this;
        }

        public String getInfo() {
            return info;
        }

        public Bulider setInfo(String info) {
            this.info = info;
            return this;
        }

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUserid() {
            return userid;
        }

        public Bulider setUserid(String userid) {
            this.userid = userid;
            return this;
        }
        public TuLingRequestObj bulid(){
            if (this.key == null || this.key.trim().equals("")){
                this.key = TuLingConfig.API_KEY;
            }

            return new TuLingRequestObj(this.key, this.info,this.loc, this.userid);
        }
    }

    public static Bulider invoke(){
        return new Bulider();
    }

    public String getKey() {
        return key;
    }

    public String getInfo() {
        return info;
    }

    public String getLoc() {
        return loc;
    }

    public String getUserid() {
        return userid;
    }


    public String sing(String secret){
        String timestamp = String.valueOf(System.currentTimeMillis());
        String keyParam = secret + timestamp + this.key;
        Aes aes = new Aes(DigestUtils.md5Hex(keyParam));
        String data = JSONObject.toJSONString(this);
        JSONObject json = new JSONObject();
        json.put("key", this.key);
        json.put("timestamp", timestamp);
        json.put("data", aes.encrypt(data));
        return json.toJSONString();
    }
}
