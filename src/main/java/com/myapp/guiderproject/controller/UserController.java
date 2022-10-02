package com.myapp.guiderproject.controller;

import com.myapp.guiderproject.entity.User;
import com.myapp.guiderproject.service.UserService;
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
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
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