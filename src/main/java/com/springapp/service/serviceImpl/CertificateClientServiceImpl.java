package com.springapp.service.serviceImpl;

import com.springapp.dao.CertificateClientDao;
import com.springapp.dao.CertificateDao;
import com.springapp.dao.ClientDao;
import com.springapp.helpers.FilesHelper;
import com.springapp.model.*;
import com.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CertificateClientServiceImpl implements CertificateClientService {
    @Autowired
    CertificateClientDao certificateClientDao;
    @Autowired
    CertificateService certificateService;
    @Autowired
    ClientDao clientDao;
    @Autowired
    ClientService clientService;
    @Autowired
    FileService fileService;
    @Autowired
    AppUserService appUserService;

    public Boolean createCertificateClient(Integer clientId, Integer certificateId,String certificateNumber, String date, Integer standardDuration, String auditorId, Boolean isAccredited) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date certificationDate = null;
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            certificationDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(certificateClientDao.createCertificateClient(clientDao.findClientById(clientId), certificateService.getCertificateById(certificateId),certificateNumber, certificationDate, standardDuration, appUserService.getUserById(auditorId), isAccredited)) {
            return fileService.createFolderForClientCertificate(clientDao.findClientById(clientId), certificateService.getCertificateById(certificateId).getCertificateName());
        } else {
            return false;
        }
    }

    public List<CertificateClient> getCertificatesByClientId(Integer clientId) {
        return certificateClientDao.getCertificatesByClientId(clientId) ;
    }

    public Boolean deleteCertificateForClient(Integer certificateId, Integer clientId, Integer certificateClientId) {
        List<CertificateClient> certificateClientList = certificateClientDao.getCertificatesByClientId(clientId);
        for(CertificateClient certificate : certificateClientList) {
            if(certificate.getId().equals(certificateId)) {
                fileService.deleteAllFilesForCertificateClient(clientService.findClientById(clientId),
                        certificate.getCertificate().getCertificateName(), FilesHelper.getYearFromCertificationDate(certificate.getCertificationDate().toString()));
            }
        }
        certificateClientDao.deleteCertificateForClient(certificateClientId);
        return true;
    }

    public List<CertificateClient> getAllCertificateClient() {
        return certificateClientDao.getAllCertificateClient();
    }

    @Override
    public List<CertificateClient> getClientsByCertificateId(Integer certificateId, Boolean isAccredited) {
        return certificateClientDao.getClientsByCertificateId(certificateId, isAccredited);
    }

    @Override
    public AppUser getUserWhoCertifiedClientForCertificate(String certificateId, String clientId) {
        return certificateClientDao.getUserWhoCertifiedClientForCertificate(Integer.parseInt(certificateId), Integer.parseInt(clientId));
    }

    @Override
    public CertificateClient getCertificateClientByCertificateNumber(String certificateNumber) {
        return certificateClientDao.getCertificateClientByCertificateNumber(certificateNumber);
    }

    @Override
    public CertificateClient getCertificateClientByClientIdAndCertificateName(Integer clientId, String certificateName) {
        return certificateClientDao.getCertificateByClientIdAndCertificateName(clientId, certificateName);
    }

    @Override
    public Boolean addRevision(String certificateNumber, String revision, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date revisionDate = null;
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            revisionDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CertificateClient certificateClient = getCertificateClientByCertificateNumber(certificateNumber);
        return (certificateClientDao.addRevision(certificateClient, revision, revisionDate));
    }

    @Override
    public Boolean updateCertificateClient(Boolean isAccredited, String certificateNumber, String date, Integer standardDuration) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date  certificationDate = null;
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            certificationDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CertificateClient certificateClient = getCertificateClientByCertificateNumber(certificateNumber);
        return (certificateClientDao.updateCertificateClient(isAccredited, certificateClient, certificationDate, standardDuration));

    }
}
