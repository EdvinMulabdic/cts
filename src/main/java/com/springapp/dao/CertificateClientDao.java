package com.springapp.dao;

import com.springapp.model.*;

import java.util.Date;
import java.util.List;


public interface CertificateClientDao {
    Boolean createCertificateClient(Client client, Certificate certificate, String certificateNumber, Date certificationDate, Integer standardDuration, AppUser appUser, Boolean isAccredited);

    Boolean addRevision(CertificateClient certificateClient, String revision, Date date);

    List<CertificateClient> getCertificatesByClientId(Integer clientId);

    Boolean deleteCertificateForClient(Integer certificateClientId);

    List<CertificateClient> getAllCertificateClient();

    List<CertificateClient> getClientsByCertificateId(Integer certificateId, Boolean isAccredited);

    AppUser getUserWhoCertifiedClientForCertificate(Integer certificateId, Integer clientId);

    CertificateClient getCertificateClientByCertificateNumber(String certificateNumber);

    CertificateClient getCertificateByClientIdAndCertificateName(Integer clientId, String certificateName);

    Boolean updateCertificateClient(Boolean isAccredited, CertificateClient certificateClient, Date certificationDate, Integer standardDuration);
}
