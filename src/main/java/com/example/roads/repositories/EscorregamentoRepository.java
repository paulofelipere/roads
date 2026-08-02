package com.example.roads.repositories;

import com.example.roads.entities.Escorregamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscorregamentoRepository extends JpaRepository<Escorregamento, Long> {
}
