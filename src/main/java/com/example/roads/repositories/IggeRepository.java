package com.example.roads.repositories;

import com.example.roads.entities.Igge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IggeRepository extends JpaRepository<Igge,Long> {
}
