package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.EA9001Dao;
import com.springapp.model.EA9001;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class EA9001DaoImpl extends AbstractDao<Integer, EA9001> implements EA9001Dao{
    @Override
    public List<EA9001> getAllEACodes() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }

    @Override
    public EA9001 getEaCodeById(Integer id) {
        Criteria criteria = createEntityCriteria();
        return (EA9001) criteria.add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<EA9001> getEACodesForListIds(List<Integer> eaCodeIds) {
        List<EA9001> eaCodesList = new ArrayList<>();
        for(Integer id: eaCodeIds) {
            eaCodesList.add(getEaCodeById(id));
        }
        return eaCodesList;
    }

    @Override
    public Boolean createEA9001Code(String codeName, String codeNumber) {
        EA9001 ea9001 = new EA9001();
        ea9001.setCodeName(codeName);
        ea9001.setCodeNumber(codeNumber);
        return save_update(ea9001);
    }

    @Override
    public Boolean deleteEA9001Code(Integer codeId) {
        EA9001 ea9001 = getEaCodeById(codeId);
        return delete(ea9001);
    }

    @Override
    public Boolean updateEA9001Code(String codeName, String codeNumber, Integer codeId) {
        EA9001 ea9001 = getEaCodeById(codeId);
        ea9001.setCodeNumber(codeNumber);
        ea9001.setCodeName(codeName);
        return save_update(ea9001);
    }
}
