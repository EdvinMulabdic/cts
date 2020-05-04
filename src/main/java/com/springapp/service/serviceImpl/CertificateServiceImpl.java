package com.springapp.service.serviceImpl;

import com.springapp.dao.CertificateDao;
import com.springapp.model.Certificate;
import com.springapp.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    CertificateDao certificateDao;

    public Certificate getCertificateById(Integer certificateId) {
        return certificateDao.getCertificateById(certificateId);
    }

    @Override
    public Certificate getCertificateByName(String certificateName) {
        return certificateDao.getCertificateByName(certificateName);
    }

    public List<Certificate> getAllCertificates() {
        return certificateDao.getAllCertificates();
    }
    public Boolean createCertificate(String certificateName, String certificateDuration) {
        return certificateDao.createCertificate(certificateName, Integer.parseInt(certificateDuration));
    }
    public Boolean updateCertificate(String certificateName, String certificateDuration, String certificateId) {
       return certificateDao.updateCertificate(certificateName, Integer.parseInt(certificateDuration), Integer.parseInt(certificateId));
    }

    public Boolean deleteCertificate(String certificateId) {
        return certificateDao.deleteCertificate(Integer.parseInt(certificateId));
    }

    public Certificate getCertificateByCertificateName(String certificateName) {
        return certificateDao.getCertificateByName(certificateName);
    }
}
