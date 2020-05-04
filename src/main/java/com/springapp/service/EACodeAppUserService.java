package com.springapp.service;

import com.springapp.model.*;

import java.util.List;


public interface EACodeAppUserService {
    Boolean addCodeToAppUser(String appUserId, Integer certificateId, String ea9001Id, String ea14001Id, Integer clientId );
    List<EACodeAppUser> getAllEACodesForAppUserStatistic(String appUserId);
    Boolean deleteCodeForAppUser(AppUser appUser, Certificate certificate, String clientId);
}
