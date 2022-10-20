package com.myapp.guiderproject.controller;

import com.myapp.guiderproject.entity.UserCredentials;
import com.myapp.guiderproject.service.UserCredentialsServiceForAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credentials")
public class UserCredentialsControllerForAdmin {

    private UserCredentialsServiceForAdmin userCredentialsServiceForAdmin;

    @Autowired
    public UserCredentialsControllerForAdmin(UserCredentialsServiceForAdmin userCredentialsServiceForAdmin) {
        this.userCredentialsServiceForAdmin = userCredentialsServiceForAdmin;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserCredentials>> getAll() {
        return userCredentialsServiceForAdmin.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCredentials> getCredentialsById(@PathVariable Long id) {
        return userCredentialsServiceForAdmin.getById(id);
    }

    @PostMapping
    public ResponseEntity<UserCredentials> addUser(@RequestBody UserCredentials userCredentials) {
        return userCredentialsServiceForAdmin.addUser(userCredentials);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserCredentials> deleteUser(@PathVariable Long id) {
        return userCredentialsServiceForAdmin.deleteUserById(id);
    }


}