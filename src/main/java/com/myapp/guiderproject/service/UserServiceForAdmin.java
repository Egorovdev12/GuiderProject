package com.myapp.guiderproject.service;

import com.myapp.guiderproject.dao.UserDao;
import com.myapp.guiderproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceForAdmin {

    private UserDao userDao;

    @Autowired
    public UserServiceForAdmin(UserDao userDao) {
        this.userDao = userDao;
    }

    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> userFromRepository = userDao.findUserById(id);
        if (userFromRepository.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(userFromRepository.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<User> getUserByUsername(String username) {
        Optional<User> userFromRepository = userDao.findUserByUsername(username);
        if (userFromRepository.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(userFromRepository.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<User> addUser(User user) {
        Optional<User> userFromRepositoryById = userDao.findUserById(user.getId());
        Optional<User> userFromRepositoryByName = userDao.findUserByUsername(user.getUsername());
        if (userFromRepositoryById.isEmpty() && userFromRepositoryByName.isEmpty()) {
            return new ResponseEntity<>(userDao.save(user), HttpStatus.ACCEPTED);
        }
        else if (userFromRepositoryById.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO add exception throw
        }
        else if (userFromRepositoryByName.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //TODO add exception throw
        }
        else {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    public ResponseEntity<User> deleteUser(Long id) {
        Optional<User> userFromRepository = userDao.findUserById(id);
        if (userFromRepository.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            userDao.deleteById(id);
            return new ResponseEntity<>(userFromRepository.get(), HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<User> updateUser(User user) {
        Optional<User> userFromRepository = userDao.findUserById(user.getId());
        if (userFromRepository.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            userFromRepository.get().setPublications(user.getPublications());
            userFromRepository.get().setRating(user.getRating());
            userFromRepository.get().setUsername(user.getUsername());
            return new ResponseEntity<>(userFromRepository.get(), HttpStatus.ACCEPTED);
        }
    }
}