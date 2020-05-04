package com.springapp.helpers;

import org.springframework.security.crypto.bcrypt.BCrypt;


public class UserAccessHelper {

    public static final String ADMIN = "Admin";
    public static final String UNAUTHORIZED = "unauthorized";
    public static final String USER = "user";

    public String adminAccess() {
        return "Admin";
    }

    public String userAccess() {
        return "user";
    }

    public String unauthorized() {
        return "unauthorized";
    }
}
