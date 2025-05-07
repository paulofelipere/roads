package com.example.roads.repositories;

import com.example.roads.entities.Panelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelasRepository extends JpaRepository<Panelas, String> {
}