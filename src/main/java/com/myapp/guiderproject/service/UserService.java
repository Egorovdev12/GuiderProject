package com.myapp.guiderproject.service;

import com.myapp.guiderproject.dao.UserDao;
import com.myapp.guiderproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

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

    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public void addUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    public void updateUser(User user) {
        User userFromRepository = userDao.findUserById(user.getId());
        userFromRepository.setPublications(user.getPublications());
        userFromRepository.setRating(user.getRating());
        userFromRepository.setUsername(user.getUsername());
    }
}