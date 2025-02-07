package com.example.roads.repositories;

import com.example.roads.entities.CadastroSeguimento;
import com.example.roads.entities.Deformacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroSeguimentoRepository extends JpaRepository<CadastroSeguimento,Long> {
}
