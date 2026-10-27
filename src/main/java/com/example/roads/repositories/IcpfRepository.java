package com.example.roads.repositories;

import com.example.roads.entities.Icpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IcpfRepository extends JpaRepository<Icpf, Long> {

    Optional<Icpf> findFirstBySeguimento_Id(Long seguimentoId);
}
