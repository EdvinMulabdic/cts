package com.springapp.model;

import com.springapp.helpers.ClientHelper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String clientName;
    private String contactPerson;
    private String positionInOrganization;
    private String webAddress;
    private String clientPDVNumber;
    private String address;
    private String address2;
    private String phone;
    private String email;
    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;
    private ClientHelper.clientStatus clientStatus;
    @Column(columnDefinition = "boolean default false")
    private Boolean isTransferred;

    public Integer getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPDVNumber() {
        return clientPDVNumber;
    }

    public void setClientPDVNumber(String clientPDVNumber) {
        this.clientPDVNumber = clientPDVNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPositionInOrganization() {
        return positionInOrganization;
    }

    public void setPositionInOrganization(String positionInOrganization) {
        this.positionInOrganization = positionInOrganization;
    }
    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getTransferred() {
        return isTransferred;
    }

    public void setTransferred(Boolean transferred) {
        isTransferred = transferred;
    }

    public ClientHelper.clientStatus getClientStatus() {
        return clientStatus;
    }
    public void setClientStatus(ClientHelper.clientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }
}
