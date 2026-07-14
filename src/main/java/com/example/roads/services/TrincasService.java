package com.example.roads.services;


import com.example.roads.repositories.TrincasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrincasService {
    @Autowired
    TrincasRepository trincasRepository;

}
