package com.springapp.dao;

import com.springapp.model.*;

import java.util.List;


public interface EACodeAppUserDao {
    Boolean addCodeToAppUser(AppUser appUser, Certificate certificate, EA9001 ea9001, EA14001 ea14001, Client client);

    List<EACodeAppUser> getAllEACodesForAppUserStatistic(String appUserId);
    Boolean deleteCodeForAppUser(AppUser appUser, Certificate certificate, Client client);
}
