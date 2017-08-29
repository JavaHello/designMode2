package org.lk.springboot.demo.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.lk.springboot.demo.domain.mapper.user.UserInfoMapper;
import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.lk.springboot.demo.service.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void addObj(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void delObj(Long id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateObj(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserInfo> findAll(Map<String, Object> queryMap) {
        return userInfoMapper.findAll(queryMap);
    }

    @Override
    public void registerUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public UserInfo findByUserName(String username) {
        return userInfoMapper.findByUserName(username);
    }

    @Override
    public boolean verifyExist(String username, String email) {
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("username", username);
        List<UserInfo> userInfoList = userInfoMapper.selectByUsernameOrEmail(queryMap);
        if (CollectionUtils.isNotEmpty(userInfoList)){
        	return false;
        }
        queryMap.remove("username");
        queryMap.put("email", email);
        userInfoList = userInfoMapper.selectByUsernameOrEmail(queryMap);
        if (CollectionUtils.isNotEmpty(userInfoList)){
        	return false;
        }
        return false;

    }

    @Override
    public PageInfo<UserInfo> findByPage(Map<String, Object> queryMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userInfoMapper.findAll(queryMap));
    }
}