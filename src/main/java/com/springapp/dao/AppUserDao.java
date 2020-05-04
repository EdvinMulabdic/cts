package com.springapp.dao;

import com.springapp.model.AppUser;
import com.springapp.model.EA14001;
import com.springapp.model.EA9001;
import com.springapp.model.Role;

import java.sql.SQLException;
import java.util.List;


public interface AppUserDao {
    AppUser findUserByEmail(String email) throws SQLException;

    List<EA9001> getAllEA9001FromUser(Integer userId);

    List<EA14001> getAllEA14001FromUser(Integer userId);

    AppUser getUserById(Integer userId);

    List<AppUser> getAllUsers();

    Boolean createUser(String name, String address, String city, String email, String phone, String qualifications, Role role, String password, List<EA9001> ea9001, List<EA14001> ea14001);

    Boolean updateUser(String name, String address, String city, String email, String phone, String qualifications, Role role, String password, List<EA9001> ea9001, List<EA14001> ea14001, String userId);

    Boolean deleteUser(Integer userId);

    AppUser doesUserWithEmailExist(String email);
    List<AppUser> getAllAuditUsers();
}
