package com.example.Objavemicroservis.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table

public class Lokacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
