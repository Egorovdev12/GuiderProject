package com.myapp.petcareproject.controller;

import com.myapp.petcareproject.Entity.User;
import com.myapp.petcareproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public void getUserById(@PathVariable Long id) {
        //TODO realization
    }

    @GetMapping
    public void getUserByUsername(@RequestParam String username) {
        //TODO realization
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        //TODO realization
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        //TODO realization
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        //TODO realization
    }
}