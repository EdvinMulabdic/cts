package com.springapp.service.serviceImpl;

import com.springapp.dao.EACodeAppUserDao;
import com.springapp.model.*;
import com.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EACodeAppUserServiceImpl implements EACodeAppUserService{
    @Autowired
    EACodeAppUserDao eaCodeAppUserDao;
    @Autowired
    AppUserService appUserService;
    @Autowired
    CertificateService certificateService;
    @Autowired
    EA9001Service ea9001Service;
    @Autowired
    EA14001Service ea14001Service;
    @Autowired
    ClientService clientService;

    @Override
    public Boolean addCodeToAppUser(String appUserId, Integer certificateId, String ea9001Id, String ea14001Id, Integer clientId) {
        EA9001 ea9001 = new EA9001();
        EA14001 ea14001 = new EA14001();
        if(!ea9001Id.equals("EA9001")) {
            ea9001 = ea9001Service.getEaCodeById(Integer.parseInt(ea9001Id));
        }else {
            ea9001 = null;
        }

        if (!ea14001Id.equals("EA14001")) {
            ea14001 = ea14001Service.getEaCodeById(Integer.parseInt(ea14001Id));
        }else {
            ea14001 = null;
        }
        return eaCodeAppUserDao.addCodeToAppUser(appUserService.getUserById(appUserId), certificateService.getCertificateById(certificateId), ea9001, ea14001, clientService.findClientById(clientId));
    }

    @Override
    public List<EACodeAppUser> getAllEACodesForAppUserStatistic(String appUserId) {
        return eaCodeAppUserDao.getAllEACodesForAppUserStatistic(appUserId);
    }

    @Override
    public Boolean deleteCodeForAppUser(AppUser appUser, Certificate certificate, String clientIdString) {
        return eaCodeAppUserDao.deleteCodeForAppUser(appUser, certificate, clientService.findClientById(Integer.parseInt(clientIdString)));
    }

}
