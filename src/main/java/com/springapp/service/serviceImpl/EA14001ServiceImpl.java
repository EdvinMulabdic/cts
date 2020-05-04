package com.springapp.service.serviceImpl;

import com.springapp.dao.EA14001Dao;
import com.springapp.model.EA14001;
import com.springapp.service.EA14001Service;
import com.springapp.service.EA9001Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EA14001ServiceImpl implements EA14001Service {
    @Autowired
    EA14001Dao ea14001Dao;

    public List<EA14001> getAllEACodes() {
        return ea14001Dao.getAllEACodes();
    }

    @Override
    public EA14001 getEaCodeById(Integer id) {
        return ea14001Dao.getEaCodeById(id);
    }

    @Override
    public List<EA14001> getEACodesForListIds(List<Integer> eaCodeIds) {
        return ea14001Dao.getEACodesForListIds(eaCodeIds);
    }

    @Override
    public Boolean createEA14001Code(String codeName, String codeNumber) {
        return ea14001Dao.createEA14001Code(codeName, codeNumber);

    }

    @Override
    public Boolean deleteCode(String codeId) {
        return ea14001Dao.deleteEA14001Code(Integer.parseInt(codeId));

    }

    @Override
    public Boolean updateEA14001Code(String codeName, String codeNumber, String codeId) {
        return ea14001Dao.updateEA14001Code(codeName, codeNumber, Integer.parseInt(codeId));
    }

}
