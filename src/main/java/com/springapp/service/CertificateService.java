package com.springapp.service;

import com.springapp.model.Certificate;

import java.util.List;


public interface CertificateService {
    Certificate getCertificateById(Integer certificateId);
    Certificate getCertificateByName(String certificateName);
    List<Certificate> getAllCertificates();
    Boolean createCertificate(String certificateName, String certificateDuration);
    Boolean updateCertificate(String certificateName, String certificateDuration, String certificateId);
    Boolean deleteCertificate(String certificateId);
}
