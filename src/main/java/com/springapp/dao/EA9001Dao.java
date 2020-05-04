package com.springapp.dao;

import com.springapp.model.EA9001;

import java.util.List;


public interface EA9001Dao {

    List<EA9001> getAllEACodes();

    EA9001 getEaCodeById(Integer id);

    List<EA9001> getEACodesForListIds(List<Integer> eaCodeIds);

    Boolean createEA9001Code(String codeName, String codeNumber);

    Boolean deleteEA9001Code(Integer codeId);

    Boolean updateEA9001Code(String codeName, String codeNumber, Integer Id);
}
