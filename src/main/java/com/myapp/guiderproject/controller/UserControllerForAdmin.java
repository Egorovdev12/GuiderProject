package com.myapp.guiderproject.controller;

import com.myapp.guiderproject.entity.User;
import com.myapp.guiderproject.service.UserServiceForAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserControllerForAdmin {

    private UserServiceForAdmin userServiceForAdmin;

    @Autowired
    public UserControllerForAdmin(UserServiceForAdmin userServiceForAdmin) {
        this.userServiceForAdmin = userServiceForAdmin;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userServiceForAdmin.getUserById(id);
    }

    @GetMapping
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) {
        return userServiceForAdmin.getUserByUsername(username);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
       return userServiceForAdmin.addUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return userServiceForAdmin.deleteUser(id);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        //TODO понять что будет, если передать юзера без id
        //TODO обработать ситуацию, при которой мы меняем никнейм на уже существующий
        //TODO разобраться с sequence_generator
        //TODO dont repeat yourself в сервисе
        return userServiceForAdmin.updateUser(user);
    }
}