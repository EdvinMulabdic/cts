package com.springapp.model;

import javax.persistence.*;


@Entity
@Table(name = "ea_code_appuser")
public class EACodeAppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private AppUser appUser;
    @OneToOne
    private Certificate certificate;
    @OneToOne
    private EA9001 ea9001;
    @OneToOne
    private EA14001 ea14001;
    @OneToOne
    private Client client;

    private Integer counter;

    public Integer getId() {
        return id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public EA9001 getEa9001() {
        return ea9001;
    }

    public void setEa9001(EA9001 ea9001) {
        this.ea9001 = ea9001;
    }

    public EA14001 getEa14001() {
        return ea14001;
    }

    public void setEa14001(EA14001 ea14001) {
        this.ea14001 = ea14001;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
