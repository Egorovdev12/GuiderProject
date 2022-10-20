package com.myapp.guiderproject.dao;

import com.myapp.guiderproject.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentials, Long> {

    List<UserCredentials> findAll();
    Optional<UserCredentials> findById(Long id);
    boolean existsByEmail(String email);
    boolean existsById(Long id);
    void deleteById(Long id);
}
