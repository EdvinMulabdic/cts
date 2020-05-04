package com.springapp.dao;

import com.springapp.model.Role;

import java.util.List;


public interface RoleDao {
    Role getUserAccessRole(String role);

    List<Role> getAllRoles();
}
