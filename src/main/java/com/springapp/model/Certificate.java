package com.springapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String certificateName;
    private Integer certificateDuration;
    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

    public Integer getId() {
        return id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public Integer getCertificateDuration() {
        return certificateDuration;
    }

    public void setCertificateDuration(Integer certificateDuration) {
        this.certificateDuration = certificateDuration;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
