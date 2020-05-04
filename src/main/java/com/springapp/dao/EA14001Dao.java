package com.springapp.dao;

import com.springapp.model.EA14001;

import java.util.List;


public interface EA14001Dao {

    List<EA14001> getAllEACodes();

    EA14001 getEaCodeById(Integer id);

    List<EA14001> getEACodesForListIds(List<Integer> eaCodeIds);

    Boolean updateEA14001Code(String codeName, String codeNumber, Integer codeId);

    Boolean deleteEA14001Code(Integer codeId);

    Boolean createEA14001Code(String codeName, String codeNumber);
}
