package org.lk.springboot.demo.web.controller;

import org.junit.Test;
import org.lk.springboot.demo.BaseApiControllerTest;
import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserControllerTest extends BaseApiControllerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final static String reqUrl = "/v1/user/";
    @Test
    public void testList() throws Exception {
    	logger.debug("");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("");
        userInfo.setNickname("");
        userInfo.setProvince("");
        super.post(reqUrl + "list", userInfo);
    }

    public void update() throws Exception {
    }

    @Test
    public void testAdd() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("qiuhiu");
        userInfo.setUpassword("123");
        userInfo.setEmail("123@qw.com");
        userInfo.setJob("java");
        userInfo.setProvince("湖南省");
        userInfo.setCity("长沙市");
        userInfo.setDistrict("岳麓区");
        userInfo.setAddress("hello");
        userInfo.setGender((short) 1);
        super.post(reqUrl + "add", userInfo);
    }

    public void delete() throws Exception {
    }

}
