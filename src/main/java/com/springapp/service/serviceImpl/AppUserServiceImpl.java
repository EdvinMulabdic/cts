package com.springapp.service.serviceImpl;

import com.springapp.dao.AppUserDao;
import com.springapp.dao.RoleDao;
import com.springapp.helpers.UserAccessHelper;
import com.springapp.model.AppUser;
import com.springapp.model.EA14001;
import com.springapp.model.EA9001;
import com.springapp.model.Role;
import com.springapp.service.AppUserService;
import com.springapp.service.EA14001Service;
import com.springapp.service.EA9001Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    EA9001Service ea9001Service;
    @Autowired
    EA14001Service ea14001Service;

    /* ------------------- authenticate user ------------------ */
    public String authenticate(String email, String password) throws SQLException {
        AppUser appUser = userDao.findUserByEmail(email);
        if(appUser != null && BCrypt.checkpw(password, appUser.getPassword())) {
            if(appUser.getRole().getName().equals(UserAccessHelper.ADMIN)) {
                return UserAccessHelper.ADMIN;
            } else if(appUser.getRole().getName().equals(UserAccessHelper.USER)) {
                return UserAccessHelper.USER;
            }
        }
        return UserAccessHelper.UNAUTHORIZED;
    }

//    public Boolean isAuthenticated() {
//        Session
//    }

    public List<EA9001> getEA9001(Integer id) {
        return userDao.getAllEA9001FromUser(id);
    }

    public List<EA14001> getEA14001(Integer id) {
        return userDao.getAllEA14001FromUser(id);
    }

    public AppUser getUserById(String userId) {
        return userDao.getUserById(Integer.parseInt(userId));
    }

    public List<AppUser> getAllUsers() {
        return userDao.getAllUsers();
    }

    public Boolean createUser(String name, String address, String city, String email, String phone, String qualifications, String role, String password, String[] ea9001arr, String[] ea14001arr) {
        List<Integer> ea9001 = new ArrayList<>();
        List<Integer> ea14001 = new ArrayList<>();
       if(ea9001arr.length > 0) {
           List<String> eaCodesListString = Arrays.asList(ea9001arr);
           for (String s : eaCodesListString) {
               ea9001.add(Integer.parseInt(s));
           }
       }
        if(ea14001arr.length > 0) {
            List<String> eaCodesListString = Arrays.asList(ea14001arr);
            for (String s : eaCodesListString) {
                ea14001.add(Integer.parseInt(s));
            }
        }
        if(userDao.doesUserWithEmailExist(email) == null) {
            return userDao.createUser(name, address, city, email, phone, qualifications, checkForUserRole(role), password, ea9001Service.getEACodesForListIds(ea9001), ea14001Service.getEACodesForListIds(ea14001));
        } else {
           return false;
        }
    }

    public Boolean updateUser(String name, String address, String city, String email, String phone, String qualifications, String role, String password,String[] ea9001arr, String[] ea14001arr, String userId) {
        List<Integer> ea9001 = new ArrayList<>();
        List<Integer> ea14001 = new ArrayList<>();
        if(ea9001arr.length != 0) {
            List<String> eaCodesListString = Arrays.asList(ea9001arr);
            for (String s : eaCodesListString) {
                ea9001.add(Integer.parseInt(s));
            }
        }
        if(ea14001arr.length != 0) {
            List<String> eaCodesListString = Arrays.asList(ea14001arr);
            for (String s : eaCodesListString) {
                ea14001.add(Integer.parseInt(s));
            }
        }
        if(userDao.doesUserWithEmailExist(email) != null) {
            return userDao.updateUser(name, address, city, email, phone, qualifications, checkForUserRole(role), password, ea9001Service.getEACodesForListIds(ea9001), ea14001Service.getEACodesForListIds(ea14001), userId);
        } else {
            return false;
        }
    }

    public Boolean deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public List<AppUser> getAllAuditUsers() {
        return userDao.getAllAuditUsers();
    }

    private Role checkForUserRole(String role) {
         if(role.equals(UserAccessHelper.USER)) {
            return roleDao.getUserAccessRole(role);
        } else {
            return roleDao.getUserAccessRole(UserAccessHelper.UNAUTHORIZED);
        }
    }
}
