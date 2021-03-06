package com.springapp.service;

import com.springapp.model.EA14001;

import java.util.List;


public interface EA14001Service {
    List<EA14001> getAllEACodes();
    EA14001 getEaCodeById(Integer id);
    List<EA14001> getEACodesForListIds(List<Integer> eaCodeIds);
    Boolean createEA14001Code(String codeName, String codeNumber);
    Boolean deleteCode(String codeId);
    Boolean updateEA14001Code(String codeName, String codeNumber, String codeId);
}
