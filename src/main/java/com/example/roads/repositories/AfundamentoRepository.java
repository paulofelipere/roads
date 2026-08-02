package com.example.roads.repositories;

import com.example.roads.entities.Afundamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfundamentoRepository extends JpaRepository<Afundamento, Long> {
}
