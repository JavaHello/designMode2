package org.lk.springboot.demo.domain.mapper.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.lk.springboot.demo.domain.model.user.UserInfo;

@Mapper
public interface UserInfoMapper {
	int deleteByPrimaryKey(Long id);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	UserInfo selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);

	List<UserInfo> findAll(Map<String, Object> queryMap);

	UserInfo findByUserName(String username);

	List<UserInfo> selectByUsernameOrEmail(Map<String, Object> queryMap);
}