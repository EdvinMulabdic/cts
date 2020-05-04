package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.CertificateClientDao;
import com.springapp.dao.CertificateDao;
import com.springapp.model.*;
import com.springapp.service.CertificateService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Repository
@Transactional
public class CertificateClientDaoImpl extends AbstractDao<Integer, CertificateClient> implements CertificateClientDao {


    @Autowired
    CertificateService certificateService;

    public Boolean createCertificateClient(Client client, Certificate certificate, String certificateNumber, Date certificationDate, Integer standardDuration, AppUser appUser, Boolean isAccredited) {
        CertificateClient certificateClient = new CertificateClient();
        if(!checkIfClientWithCertificateExistInDB(client, certificate)) {
            certificateClient.setClient(client);
            certificateClient.setCertificate(certificate);
            certificateClient.setAccredited(isAccredited);
            certificateClient.setCertificateNumber(certificateNumber);
            certificateClient.setCertificationDate(certificationDate);
            certificateClient.setAppUser(appUser);
            Calendar c = Calendar.getInstance();
            c.setTime(certificationDate);
            if (standardDuration == 3) {
                c.add(Calendar.YEAR, certificate.getCertificateDuration());
            } else {
                c.add(Calendar.YEAR, standardDuration);
            }
            certificateClient.setExpirationDate(c.getTime());
            return persist(certificateClient);
        }else {
            return false;
        }
    }

    @Override
    public Boolean addRevision(CertificateClient certificateClient, String revision, Date date) {
        if (revision.equals("1")) {
            certificateClient.setFirstRevisionDate(date);
        } else {
            certificateClient.setSecondRevisionDate(date);
        }
        return save_update(certificateClient);
    }

    public List<CertificateClient> getCertificatesByClientId(Integer clientId) {
        Criteria criteria = createEntityCriteria();
        return criteria.add(Restrictions.eq("client.id", clientId)).list();
    }

    public CertificateClient getCertificateByClientIdAndCertificateName(Integer clientId, String certificateName) {
        Criteria criteria = createEntityCriteria();
        Certificate certificate = certificateService.getCertificateByName(certificateName);
        Criterion criterion_clientId = Restrictions.eq("client.id", clientId);
        Criterion criterion_certificateId = Restrictions.eq("certificate.id", certificate.getId());

        Criterion completeCriterion = Restrictions.conjunction().add(criterion_clientId).add(criterion_certificateId);
        return (CertificateClient) criteria.add(completeCriterion).uniqueResult();
    }

    @Override
    public Boolean updateCertificateClient(Boolean isAccredited, CertificateClient certificateClient, Date certificationDate, Integer standardDuration) {
        certificateClient.setAccredited(isAccredited);
        certificateClient.setCertificationDate(certificationDate);
        Calendar c = Calendar.getInstance();
        c.setTime(certificationDate);
        if (standardDuration == 3) {
            c.add(Calendar.YEAR, certificateClient.getCertificate().getCertificateDuration());
        } else {
            c.add(Calendar.YEAR, standardDuration);
        }
        certificateClient.setExpirationDate(c.getTime());

        return save_update(certificateClient);
    }

    public Boolean deleteCertificateForClient(Integer certificateClientId) {
        Criteria criteria = createEntityCriteria();
        CertificateClient certificateClient = (CertificateClient) criteria.add(Restrictions.eq("id", certificateClientId)).uniqueResult();
        return delete(certificateClient);
    }

    public List<CertificateClient> getAllCertificateClient() {
        Criteria criteria = createEntityCriteria();
        return criteria.list() ;
    }

    @Override
    public List<CertificateClient> getClientsByCertificateId(Integer certificateId, Boolean isAccredited) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_certificate_id = Restrictions.eq("certificate.id", certificateId);
        Criterion criterion_accredited = Restrictions.eq("isAccredited", isAccredited );

        Criterion completeCriterion = Restrictions.conjunction().add(criterion_certificate_id).add(criterion_accredited);

        return criteria.add(completeCriterion).list();

//        return criteria.add(Restrictions.eq("certificate.id", certificateId)).list();
    }

    @Override
    public AppUser getUserWhoCertifiedClientForCertificate(Integer certificateId, Integer clientId) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_appUser = Restrictions.eq("client.id", clientId);
        Criterion criterion_certificateId = Restrictions.eq("certificate.id", certificateId);
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_appUser).add(criterion_certificateId);
        CertificateClient certificateClient = (CertificateClient) criteria.add(completeCriterion).uniqueResult();
        AppUser appUser = certificateClient.getAppUser();
        return appUser;
    }

    @Override
    public CertificateClient getCertificateClientByCertificateNumber(String certificateNumber) {
        Criteria criteria = createEntityCriteria();
        return  (CertificateClient) criteria.add(Restrictions.eq("certificateNumber", certificateNumber)).uniqueResult();

    }

    private Boolean checkIfClientWithCertificateExistInDB(Client client, Certificate certificate) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_appUser = Restrictions.eq("client.id", client.getId());
        Criterion criterion_certificateId = Restrictions.eq("certificate.id", certificate.getId());
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_appUser).add(criterion_certificateId);
        if(criteria.add(completeCriterion).uniqueResult() != null) {
            return true;
        }
        return false;
    }
}
