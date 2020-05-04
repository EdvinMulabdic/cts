package com.springapp.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
