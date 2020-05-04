package com.springapp.service.serviceImpl;

import com.springapp.dao.EA9001Dao;
import com.springapp.model.EA9001;
import com.springapp.service.EA9001Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EA9001ServiceImpl implements EA9001Service {
    @Autowired
    EA9001Dao ea9001Dao;

    @Override
    public Boolean createEA9001Code(String codeName, String codeNumber) {
        return ea9001Dao.createEA9001Code(codeName, codeNumber);
    }
    public List<EA9001> getAllEACodes() {
        return ea9001Dao.getAllEACodes();
    }

    @Override
    public EA9001 getEaCodeById(Integer id) {
        return ea9001Dao.getEaCodeById(id);
    }

    @Override
    public List<EA9001> getEACodesForListIds(List<Integer> eaCodeIds) {
        return ea9001Dao.getEACodesForListIds(eaCodeIds);
    }

    @Override
    public Boolean deleteCode(String codeId) {
        return ea9001Dao.deleteEA9001Code(Integer.parseInt(codeId));
    }

    @Override
    public Boolean updateEA9001Code(String codeName, String codeNumber, String codeId) {
        return ea9001Dao.updateEA9001Code(codeName, codeNumber, Integer.parseInt(codeId));
    }

}
