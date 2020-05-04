package com.springapp.model;

import javax.persistence.*;


@Entity
@Table(name = "ea_14001")
public class EA14001 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String codeNumber;
    private String codeName;

    public Integer getId() {
        return id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }
}
