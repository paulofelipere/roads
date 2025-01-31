package com.example.roads.servicies;

import com.example.roads.repositories.RodoviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoadService {

    @Autowired RodoviaRepository rodoviaRepository;

}
