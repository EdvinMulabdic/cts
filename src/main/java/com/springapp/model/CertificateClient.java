package com.springapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "certificate_client")
public class CertificateClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Client client;
    @OneToOne
    private Certificate certificate;
    private String certificateNumber;

    // Date of original certification
    @DateTimeFormat(pattern="MM-dd-yyyy")
    @Temporal(TemporalType.DATE)
    private Date certificationDate;

    // Date of transfer from another certification house
    @DateTimeFormat(pattern="MM-dd-yyyy")
    @Temporal(TemporalType.DATE)
    private Date transferDate;

    // Date of the first revision
    @DateTimeFormat(pattern="MM-dd-yyyy")
    @Temporal(TemporalType.DATE)
    private Date firstRevisionDate;

    // Date of second revision
    @DateTimeFormat(pattern="MM-dd-yyyy")
    @Temporal(TemporalType.DATE)
    private Date secondRevisionDate;

    @DateTimeFormat(pattern="MM-dd-yyyy")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @OneToOne
    private AppUser appUser;

    private Boolean isAccredited;

    public Boolean getAccredited() {
        return isAccredited;
    }

    public void setAccredited(Boolean accredited) {
        isAccredited = accredited;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Date getCertificationDate() {
        return certificationDate;
    }

    public void setCertificationDate(Date certificationDate) {
        this.certificationDate = certificationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Date getFirstRevisionDate() {
        return firstRevisionDate;
    }

    public void setFirstRevisionDate(Date firstRevisionDate) {
        this.firstRevisionDate = firstRevisionDate;
    }

    public void setSecondRevisionDate(Date secondRevisionDate) {
        this.secondRevisionDate = secondRevisionDate;
    }

    public Date getSecondRevisionDate() {
        return secondRevisionDate;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
