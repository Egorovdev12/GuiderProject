package com.myapp.guiderproject.entity;

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
    @MapsId
    private User user;

    // empty constructor for JPA specification
    public UserPersonalInfo() {

    }

}