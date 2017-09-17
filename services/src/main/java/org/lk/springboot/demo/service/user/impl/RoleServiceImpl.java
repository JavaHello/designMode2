package org.lk.springboot.demo.service.user.impl;

import com.github.pagehelper.PageInfo;
import org.lk.springboot.demo.domain.mapper.user.RoleMapper;
import org.lk.springboot.demo.domain.model.user.Role;
import org.lk.springboot.demo.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> findByPage(Map<String, Object> queryMap, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void addObj(Role role) {

    }

    @Override
    public void delObj(Long id) {

    }

    @Override
    public void updateObj(Role role) {

    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public List<Role> findAll(Map<String, Object> queryMap) {
        return null;
    }

    @Override
    public List<Role> queryAll() {
        return roleMapper.queryAll();
    }
}
