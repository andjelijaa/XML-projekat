package com.example.Objavemicroservis.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Lajk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean lajkovano = true;

    @Column
    private String opis;

    //ili je za komentare lista?
    @Column
    private String komentari;

    @ManyToMany
    private List<Tagovi> tagovi;

    @OneToOne
    private Lokacija lokacija;

    @OneToOne
    private Album album;
}
