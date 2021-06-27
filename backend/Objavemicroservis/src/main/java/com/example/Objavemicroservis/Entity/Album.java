package com.example.Objavemicroservis.Entity;


import javax.persistence.*;

@Table
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
