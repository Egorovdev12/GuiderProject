package com.myapp.guiderproject.service;

import com.myapp.guiderproject.dao.UserCredentialsDao;
import com.myapp.guiderproject.entity.UserCredentials;
import com.myapp.guiderproject.exception.IncorrectRequestException;
import com.myapp.guiderproject.exception.UserAlreadyExistsException;
import com.myapp.guiderproject.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCredentialsServiceForAdmin {

    UserCredentialsDao userCredentialsDao;

    @Autowired
    public UserCredentialsServiceForAdmin(UserCredentialsDao userCredentialsDao) {
        this.userCredentialsDao = userCredentialsDao;
    }

    public ResponseEntity<List<UserCredentials>> getAll() {
        return new ResponseEntity<>(userCredentialsDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<UserCredentials> getById(Long id) {
        Optional<UserCredentials> credentials = userCredentialsDao.findById(id);
        if (credentials.isEmpty()) {
            throw new UserNotFoundException("User with id = " + id + " not found");
        }
        else {
            return new ResponseEntity<>(credentials.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<UserCredentials> addUser(UserCredentials userCredentials) {
        if (userCredentials.getId() != null) {
            throw new IncorrectRequestException("You cannot use POST request with explicit id");
        }
        else if (userCredentialsDao.existsByEmail(userCredentials.getEmail())) {
            throw new UserAlreadyExistsException("Such email already exists");
        }
        else {
            return new ResponseEntity<>(userCredentialsDao.save(userCredentials), HttpStatus.ACCEPTED);
        }

    }

    public ResponseEntity<UserCredentials> deleteUserById(Long id) {
        if (userCredentialsDao.existsById(id)) {
            UserCredentials deletedUser = userCredentialsDao.findById(id).get();
            userCredentialsDao.deleteById(id);
            return new ResponseEntity<>(deletedUser, HttpStatus.OK);
        }
        else {
            throw new UserNotFoundException("User with id = " + id + " not found");
        }
    }
}