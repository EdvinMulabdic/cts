package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.CertificateDao;
import com.springapp.model.Certificate;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CertificateDaoImpl extends AbstractDao<Integer, Certificate> implements CertificateDao {

    public Certificate getCertificateById(Integer certificateId) {
        Criteria criteria = createEntityCriteria();
        return (Certificate) criteria.add(Restrictions.eq("id", certificateId)).uniqueResult();
    }

    public List<Certificate> getAllCertificates() {
        Criteria criteria = createEntityCriteria();

        return criteria.add(Restrictions.eq("isActive", true)).list();
    }

    public Boolean createCertificate(String certificateName, Integer certificateDuration) {
        Certificate certificate = new Certificate();
        certificate.setCertificateName(certificateName);
        certificate.setCertificateDuration(certificateDuration);
        certificate.setActive(true);

        return persist(certificate);
    }

    public Boolean updateCertificate(String certificateName, Integer certificateDuration, Integer certificateId) {
        Certificate certificate = getCertificateById(certificateId);
        certificate.setCertificateName(certificateName);
        certificate.setCertificateDuration(certificateDuration);
        return update(certificate);
    }

    public Boolean deleteCertificate(Integer certificateId) {
        Certificate certificate = getCertificateById(certificateId);
        certificate.setActive(false);
        return update(certificate);
    }

    @Override
    public Certificate getCertificateByName(String certificateName) {
        Criteria criteria = createEntityCriteria();
        return (Certificate) criteria.add(Restrictions.eq("certificateName", certificateName)).uniqueResult();
    }


}
