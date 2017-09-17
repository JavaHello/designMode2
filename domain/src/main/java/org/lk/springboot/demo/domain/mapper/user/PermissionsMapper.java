package org.lk.springboot.demo.domain.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.lk.springboot.demo.domain.model.user.Permissions;

@Mapper
public interface PermissionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
    
    List<Permissions> findByUserId(Long id);

	List<Permissions> findAll();
}