package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Desgaste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String descricao;

}
