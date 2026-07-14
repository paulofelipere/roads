package com.example.roads.repositories;


import com.example.roads.entities.Remendos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemendosRepository extends JpaRepository<Remendos, Long>{

}
