package com.example.Objavemicroservis.Entity;

import lombok.Data;
import com.example.Objavemicroservis.Entity.Objava;
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

    @ManyToMany
    private List<Hashtag> hashtagovi;

    @OneToOne
    private Lokacija lokacija;

    @OneToOne
    private Album album;

    @OneToOne
    private Objava objava;

    @ManyToMany
    private List<Lajk> lajkovi;

    @ManyToMany
    private List<Komentar> komentari;



}
