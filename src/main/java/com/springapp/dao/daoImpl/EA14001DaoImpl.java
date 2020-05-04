package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.EA14001Dao;
import com.springapp.model.EA14001;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class EA14001DaoImpl extends AbstractDao<Integer, EA14001> implements EA14001Dao {
    @Override
    public List<EA14001> getAllEACodes() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }

    @Override
    public EA14001 getEaCodeById(Integer id) {
        Criteria criteria = createEntityCriteria();
        return (EA14001) criteria.add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<EA14001> getEACodesForListIds(List<Integer> eaCodeIds) {
        List<EA14001> eaCodesList = new ArrayList<>();
        for(Integer id: eaCodeIds) {
            eaCodesList.add(getEaCodeById(id));
        }
        return eaCodesList;
    }

    @Override
    public Boolean updateEA14001Code(String codeName, String codeNumber, Integer codeId) {
        EA14001 ea14001 = getEaCodeById(codeId);
        ea14001.setCodeNumber(codeNumber);
        ea14001.setCodeName(codeName);
        return save_update(ea14001);
    }

    @Override
    public Boolean deleteEA14001Code(Integer codeId) {
        EA14001 ea14001 = getEaCodeById(codeId);
        return delete(ea14001);
    }

    @Override
    public Boolean createEA14001Code(String codeName, String codeNumber) {
        EA14001 ea14001 = new EA14001();
        ea14001.setCodeName(codeName);
        ea14001.setCodeNumber(codeNumber);
        return save_update(ea14001);
    }
}
