package com.myapp.guiderproject.service;

import com.myapp.guiderproject.dao.UserDao;
import com.myapp.guiderproject.entity.User;
import com.myapp.guiderproject.exception.UserAlreadyExistsException;
import com.myapp.guiderproject.exception.UserNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceForAdmin {

    private UserDao userDao;
    private Optional<User> userFromRepository;

    @Autowired
    public UserServiceForAdmin(UserDao userDao) {
        this.userDao = userDao;
    }

    private ResponseEntity<User> checkUserIsEmpty() {
        if (userFromRepository.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        else {
            return new ResponseEntity<>(userFromRepository.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<User> getUserById(Long id) {
        userFromRepository = userDao.findUserById(id);
        return checkUserIsEmpty();
    }

    public ResponseEntity<User> getUserByUsername(String username) {
        userFromRepository = userDao.findUserByUsername(username);
        return checkUserIsEmpty();
    }

    public ResponseEntity<User> addUser(@NotNull User user) {
        Optional<User> userFromRepositoryById = userDao.findUserById(user.getId());
        Optional<User> userFromRepositoryByName = userDao.findUserByUsername(user.getUsername());
        if (userFromRepositoryById.isEmpty() && userFromRepositoryByName.isEmpty()) {
            return new ResponseEntity<>(userDao.save(user), HttpStatus.CREATED);
        }
        else if (userFromRepositoryById.isPresent()) {
            throw new UserAlreadyExistsException("A user with id = " + userFromRepositoryById.get().getId() + " already exists");
        }
        else if (userFromRepositoryByName.isPresent()) {
            throw new UserAlreadyExistsException("A user with the same name already exists");
        }
        else {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    public ResponseEntity<User> deleteUser(Long id) {
        userFromRepository = userDao.findUserById(id);
        if (userFromRepository.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            userDao.deleteById(id);
            return new ResponseEntity<>(userFromRepository.get(), HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<User> updateUser(@NotNull User user) {
        // check id !=null
        if (user.getId().equals(null)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // check name!=""
        if (user.getUsername().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // check no such name
        if (userDao.existsUserByUsername(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userFromRepository = userDao.findUserById(user.getId());
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