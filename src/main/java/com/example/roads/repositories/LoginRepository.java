package com.example.roads.repositories;

import java.util.Optional;

import com.example.roads.entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserLogin, Long>{

    Optional<UserLogin> findByUsername(String username);

}