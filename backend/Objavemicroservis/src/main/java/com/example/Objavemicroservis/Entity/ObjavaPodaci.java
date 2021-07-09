package com.example.Objavemicroservis.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table

public class ObjavaPodaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean lajkovano = true;

    @Column
    private String opis;

    @Column(nullable = false, unique = true, length = 64)
    private String nazivFajla;

    @Column
    private String username;

    @ManyToMany
    private List<KorisnikTag> korisnikTagovi;

    @Column
    private String hashtagovi;

    @Column
    private String lokacija;

    @OneToOne
    private Album album;



    @OneToMany
    private List<Lajk> lajkovi;

    @ManyToMany
    private List<Komentar> komentari;



}
