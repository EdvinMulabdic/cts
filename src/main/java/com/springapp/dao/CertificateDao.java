package com.springapp.dao;

import com.springapp.model.Certificate;

import java.util.List;


public interface
CertificateDao {
    Certificate getCertificateById(Integer certificateId);

    List<Certificate> getAllCertificates();

    Boolean createCertificate(String certificateName, Integer certificateDuration);
    Boolean updateCertificate(String certificateName, Integer certificateDuration, Integer certificateId);
    Boolean deleteCertificate(Integer certificateId);

    Certificate getCertificateByName(String certificateName);
}
