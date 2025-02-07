package com.example.roads.repositories;

import com.example.roads.entities.Trincas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrincasRepository extends JpaRepository<Trincas,Long> {
}
