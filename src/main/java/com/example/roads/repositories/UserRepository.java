package com.example.roads.repositories;

import com.example.roads.entities.Rodovia;
import com.example.roads.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
