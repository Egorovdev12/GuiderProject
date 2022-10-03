package com.myapp.guiderproject.dao;

import com.myapp.guiderproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    // SELECT * FROM users WHERE id = x
    User findUserById(Long id);
    // SELECT * FROM users WHERE username = x
    User findUserByUsername(String username);
    // DELETE * FROM users WHERE id = x
    void deleteById(Long id);
}