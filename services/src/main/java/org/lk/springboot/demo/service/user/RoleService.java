package org.lk.springboot.demo.service.user;

import org.lk.springboot.demo.domain.model.user.Role;
import org.lk.springboot.demo.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role>{
    List<Role> queryAll();
}
