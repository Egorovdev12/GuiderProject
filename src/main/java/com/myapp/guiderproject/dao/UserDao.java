package com.myapp.guiderproject.dao;

import com.myapp.guiderproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    // SELECT * FROM users WHERE id = x
    Optional<User> findUserById(Long id);
    // SELECT * FROM users WHERE username = x
    Optional<User> findUserByUsername(String username);
    // DELETE * FROM users WHERE id = x
    void deleteById(Long id);
    // SELECT EXISTS(SELECT * FROM users WHERE username = x
    boolean existsUserByUsername(String username);
}