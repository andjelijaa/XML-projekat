package com.example.Profilmicroservis.Entitiy;


import javax.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ProfilKategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nazivKategorije;
}
