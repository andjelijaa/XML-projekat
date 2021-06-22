package com.example.Objavemicroservis.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ObjavaPodaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Objava objava;
    @ManyToMany
    private List<Lajk> lajkovi;
    @ManyToMany
    private List<Komentar> komentari;

}
