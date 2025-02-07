package com.example.roads.repositories;

import com.example.roads.entities.DefeitosPavimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefeitosPavimentoRepository extends JpaRepository<DefeitosPavimentos,Long> {
}
