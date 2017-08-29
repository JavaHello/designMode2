package org.lk.springboot.demo.service.user;

import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.lk.springboot.demo.service.BaseService;

public interface UserInfoService extends BaseService<UserInfo> {

    /**
     * 注册用户
     * @param userInfo 用户信息
     */
    void registerUser(UserInfo userInfo);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return userInfo
     */
    UserInfo findByUserName(String username);

    /**
     * 根据用户登录名或者邮箱验证用户是否存在
     * @param username 用户名称
     * @param email 邮箱
     * @return 是否存在
     */
    boolean verifyExist(String username, String email) ;
}