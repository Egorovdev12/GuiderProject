package com.myapp.guiderproject.entity;

import javax.persistence.*;

@Entity
public class UserCredentials {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    // empty constructor for JPA specification
    public UserCredentials() {

    }

}