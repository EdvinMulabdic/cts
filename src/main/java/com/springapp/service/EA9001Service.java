package com.springapp.service;

import com.springapp.model.EA9001;

import java.util.List;


public interface EA9001Service {
    Boolean createEA9001Code(String codeName, String codeNumber);
    List<EA9001> getAllEACodes();
    EA9001 getEaCodeById(Integer id);
    List<EA9001> getEACodesForListIds(List<Integer> eaCodeIds);
    Boolean deleteCode(String codeId);
    Boolean updateEA9001Code(String codeName, String codeNumber, String codeId);
}
