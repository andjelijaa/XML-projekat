package com.example.Objavemicroservis.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table
@Entity
public class Objava {
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
    private String komentari;

    @Column
    private String username;

    @ManyToMany
    private List<KorisnikTag> korisnikTagovi;

    @ManyToMany
    private List<Hashtag> hashtagovi;

    @OneToOne
    private Lokacija lokacija;

    @OneToOne
    private Album album;


}
