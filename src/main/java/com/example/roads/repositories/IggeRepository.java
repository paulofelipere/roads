package com.example.roads.repositories;

import com.example.roads.entities.Igge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IggeRepository extends JpaRepository<Igge, Long> {

    Optional<Igge> findFirstBySeguimento_Id(Long seguimentoId);
}
