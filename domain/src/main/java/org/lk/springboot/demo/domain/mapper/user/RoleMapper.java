package org.lk.springboot.demo.domain.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.lk.springboot.demo.domain.model.user.Role;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> findByUserId(Long id);

    List<Role> queryAll();
}