package com.example.Profilmicroservis;


import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProfilKategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nazivKategorije;
}
