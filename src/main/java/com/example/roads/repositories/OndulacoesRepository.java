package com.example.roads.repositories;

import com.example.roads.entities.Ondulacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OndulacoesRepository extends JpaRepository<Ondulacoes, Long> {

}
