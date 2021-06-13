package com.example.Profilmicroservis;


import com.example.Profilmicroservis.Entity.Enumeracija.Pol;
import com.example.Profilmicroservis.Entity.Enumeracija.Uloga;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Profil")
public class Profil {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String email;

        @Column
        private String ime;

        @Column
        private String prezime;


        @Column
        private String telefon;

        @Column
        private String webSite;

        @Column
        private String biografija;

        @Column
        private Date datumRodjenja;

        @Column
        private Pol pol;

        @Column
        private Uloga uloga;

        @Column
        private boolean javniprofil = false;

        @Column
        private boolean publicDM = true;

        @Column
        private boolean taggable = true;
}
