package com.example.Objavemicroservis.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tagovi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;
}
