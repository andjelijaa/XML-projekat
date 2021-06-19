package com.example.Objavemicroservis.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Lokacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String naziv_mesta;
}
