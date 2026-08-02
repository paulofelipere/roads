package com.example.roads.repositories;


import com.example.roads.entities.Deformacoes;
import com.example.roads.entities.Exsudacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeformacoesRepository extends JpaRepository<Deformacoes, Long> {
}
