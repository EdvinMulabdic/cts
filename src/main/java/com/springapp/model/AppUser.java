package com.springapp.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "appuser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String city;
    private String address;
    private String workTime;
    private String qualifications;
    private String password;
    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;
    @ManyToOne
    private Role role;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EA9001> ea9001List;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EA14001> ea14001List;

    public AppUser(){}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<EA9001> getEa9001List() {
        return ea9001List;
    }

    public void setEa9001List(List<EA9001> ea9001List) {
        this.ea9001List = ea9001List;
    }

    public List<EA14001> getEa14001List() {
        return ea14001List;
    }

    public void setEa14001List(List<EA14001> ea14001List) {
        this.ea14001List = ea14001List;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkTime() {
        return this.workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getQualifications() {
        return this.qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
