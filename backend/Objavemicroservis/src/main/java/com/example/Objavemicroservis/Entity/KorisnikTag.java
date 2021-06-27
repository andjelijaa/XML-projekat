package com.example.Objavemicroservis.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class KorisnikTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
}
