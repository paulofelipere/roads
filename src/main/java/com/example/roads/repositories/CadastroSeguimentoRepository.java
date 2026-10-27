package com.example.roads.repositories;


import com.example.roads.entities.CadastroSeguimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroSeguimentoRepository extends JpaRepository<CadastroSeguimento, Long> {

    List<CadastroSeguimento> findByRodovia_IdOrderByNumSeguimentoAsc(Long rodoviaId);
}
