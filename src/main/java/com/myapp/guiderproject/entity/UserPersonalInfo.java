package com.myapp.guiderproject.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "user_personal_info")
public class UserPersonalInfo {

    // GenerationType is missing because id maps from User
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "bio")
    private String bio;

    //TODO think about cascade
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @MapsId
    private User user;

    // empty constructor for JPA specification
    public UserPersonalInfo() {

    }

}