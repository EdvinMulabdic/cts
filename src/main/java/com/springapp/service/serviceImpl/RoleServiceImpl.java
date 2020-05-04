package com.springapp.service.serviceImpl;

import com.springapp.dao.RoleDao;
import com.springapp.model.Role;
import com.springapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
