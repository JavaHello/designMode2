package org.lk.springboot.demo.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.lk.springboot.demo.exception.ApiException;
import org.lk.springboot.demo.exception.ErrorCodeEnum;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PasswordHelper {

    private String algorithmName = "md5";

    public void encryptUserPassword(UserInfo userInfo){
        String salt = getRandomUUID();
        SimpleHash simpleHash = new SimpleHash(algorithmName, userInfo.getChaos() + userInfo.getUpassword(), salt);
        userInfo.setSalt(salt);
        String userPassword = simpleHash.toHex();
        userInfo.setUpassword(userPassword);
    }

    public boolean validateUserPassword(String password,UserInfo userInfo) throws ApiException {
        SimpleHash simpleHash = new SimpleHash(algorithmName, userInfo.getChaos() + password, userInfo.getSalt());
        if (!simpleHash.toHex().equals(userInfo.getUpassword())){
            throw new ApiException(ErrorCodeEnum.ERROR_PASSWORD);
        }
        return true;
    }

    public String getRandomUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
