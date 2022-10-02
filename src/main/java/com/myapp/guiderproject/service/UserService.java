package com.myapp.guiderproject.service;

import com.myapp.guiderproject.dao.UserDao;
import com.myapp.guiderproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(Long id) {
        return userDao.findUserById(id);
    }

    public void getUserByUsername() {
        //TODO realization
    }

    public void addUser() {
        //TODO realization
    }

    public void deleteUser() {
        //TODO realization
    }

    public void updateUser() {
        //TODO realization
    }
}