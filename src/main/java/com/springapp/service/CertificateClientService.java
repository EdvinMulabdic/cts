package com.springapp.service;

import com.springapp.model.AppUser;
import com.springapp.model.Certificate;
import com.springapp.model.CertificateClient;

import java.util.Date;
import java.util.List;


public interface CertificateClientService {

    Boolean createCertificateClient(Integer clientId, Integer certificateId,String certificateNumber, String date, Integer standardDuration, String auditorId, Boolean isAccredited);
    List<CertificateClient> getCertificatesByClientId(Integer clientId);
    Boolean deleteCertificateForClient(Integer certificateId, Integer clientId, Integer certificateClientId);
    List<CertificateClient> getAllCertificateClient();
    List<CertificateClient> getClientsByCertificateId(Integer certificateId, Boolean isAccredited);
    AppUser getUserWhoCertifiedClientForCertificate(String certificateId, String clientId);
    CertificateClient getCertificateClientByCertificateNumber(String certificateNumber);
    Boolean addRevision(String certificateNumber, String revision, String date);
    Boolean updateCertificateClient(Boolean isAccredited, String certificateNumber, String date, Integer standardDuration);
    CertificateClient getCertificateClientByClientIdAndCertificateName(Integer clientId, String certificateName);
}
