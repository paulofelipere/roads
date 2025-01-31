package com.example.roads.repositories;

import com.example.roads.entities.Rodovia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RodoviaRepository extends JpaRepository<Rodovia, Integer> {
}
