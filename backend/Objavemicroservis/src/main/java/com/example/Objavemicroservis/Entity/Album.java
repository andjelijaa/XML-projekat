package com.example.Objavemicroservis.Entity;


import javax.persistence.*;

@Table(name="album")
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
