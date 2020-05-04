package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.EACodeAppUserDao;
import com.springapp.model.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class EACodeAppUserDaoImpl extends AbstractDao<Integer, EACodeAppUser> implements EACodeAppUserDao {

    @Override
    public Boolean addCodeToAppUser(AppUser appUser, Certificate certificate, EA9001 ea9001, EA14001 ea14001, Client client) {
        if (appUser != null) {
            EACodeAppUser eaCodeAppUser = new EACodeAppUser();
            eaCodeAppUser.setAppUser(appUser);
            eaCodeAppUser.setCertificate(certificate);
            eaCodeAppUser.setClient(client);
            if (ea9001 != null) {
                EACodeAppUser checkedCode = checkIfAppUserHaveEA9001Code(appUser, ea9001);
                if (checkedCode == null) {
                    eaCodeAppUser.setEa9001(ea9001);
                    eaCodeAppUser.setCounter(1);
                    return save_update(eaCodeAppUser);

                } else {
                    updateAppUserWithEA9001Code(appUser, ea9001);
                }
            } else if (ea14001 != null) {
                EACodeAppUser checkedCode = checkIfAppUserHaveEA14001Code(appUser, ea14001);
                if (checkedCode == null) {
                    eaCodeAppUser.setEa14001(ea14001);
                    eaCodeAppUser.setCounter(1);
                    return save_update(eaCodeAppUser);

                } else {
                    updateAppUserWithEA14001Code(appUser, ea14001);
                }
            }
        }
        return false;
    }

    @Override
    public List<EACodeAppUser> getAllEACodesForAppUserStatistic(String appUserId) {
        Criteria criteria = createEntityCriteria();
        return criteria.add(Restrictions.eq("appUser.id", Integer.parseInt(appUserId))).list();

    }

    @Override
    public Boolean deleteCodeForAppUser(AppUser appUser, Certificate certificate, Client client) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_appUser = Restrictions.eq("appUser.id", appUser.getId());
        Criterion criterion_certificateId = Restrictions.eq("certificate.id", certificate.getId());
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_appUser).add(criterion_certificateId);
        List<EACodeAppUser> certificateList = (List<EACodeAppUser>) criteria.add(completeCriterion).list();
        for(EACodeAppUser codeAppUser: certificateList) {
//            if (codeAppUser.getClient().getId() == client.getId()) {
                if (codeAppUser.getCounter() > 1) {
                    codeAppUser.setCounter(codeAppUser.getCounter() - 1);
                    return save_update(codeAppUser);
                } else if (codeAppUser.getCounter() == 1) {
                    return delete(codeAppUser);
                }
//            }
        }

//        EACodeAppUser eaCodeAppUser = (EACodeAppUser) criteria.add(completeCriterion).uniqueResult();

        return false;
    }

    private Boolean checkIfAppUserWithCertificateExistInDB(AppUser appUser, Certificate certificate) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_appUser = Restrictions.eq("appUser.id", appUser.getId());
        Criterion criterion_certificateId = Restrictions.eq("certificate.id", certificate.getId());
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_appUser).add(criterion_certificateId);
        if (criteria.add(completeCriterion).uniqueResult() != null) {
            return true;
        }
        return false;
    }

    private EACodeAppUser checkIfAppUserHaveEA9001Code(AppUser appUser, EA9001 ea9001) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_appUser = Restrictions.eq("appUser.id", appUser.getId());
        Criterion criterion_certificateId = Restrictions.eq("ea9001.id", ea9001.getId());
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_appUser).add(criterion_certificateId);
        return (EACodeAppUser) criteria.add(completeCriterion).uniqueResult();
    }

    private EACodeAppUser checkIfAppUserHaveEA14001Code(AppUser appUser, EA14001 ea14001) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_appUser = Restrictions.eq("appUser.id", appUser.getId());
        Criterion criterion_certificateId = Restrictions.eq("ea14001.id", ea14001.getId());
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_appUser).add(criterion_certificateId);
        return (EACodeAppUser) criteria.add(completeCriterion).uniqueResult();
    }


    private void updateAppUserWithEA9001Code(AppUser appUser, EA9001 ea9001) {
        EACodeAppUser eaCodeAppUser = checkIfAppUserHaveEA9001Code(appUser, ea9001);
        eaCodeAppUser.setCounter(eaCodeAppUser.getCounter() + 1);
        update(eaCodeAppUser);
    }

    private void updateAppUserWithEA14001Code(AppUser appUser, EA14001 ea14001) {
        EACodeAppUser eaCodeAppUser = checkIfAppUserHaveEA14001Code(appUser, ea14001);
        eaCodeAppUser.setCounter(eaCodeAppUser.getCounter() + 1);
        update(eaCodeAppUser);
    }

}
