package com.springapp.service;

import com.springapp.model.AppUser;
import com.springapp.model.EA14001;
import com.springapp.model.EA9001;

import java.sql.SQLException;
import java.util.List;


public interface AppUserService {
     String authenticate(String email,String password) throws SQLException;
     List<EA9001> getEA9001(Integer id);
     List<EA14001> getEA14001(Integer id);
     AppUser getUserById(String userId);
     List<AppUser> getAllUsers();
     Boolean createUser(String name, String address, String city, String email, String phone, String qualifications, String role, String password, String[] ea9001, String[] ea14001);
     Boolean updateUser(String name, String address, String city, String email, String phone, String qualifications, String role, String password, String[] ea9001, String[] ea14001, String userId);
     Boolean deleteUser(Integer userId);
     List<AppUser> getAllAuditUsers();
}
