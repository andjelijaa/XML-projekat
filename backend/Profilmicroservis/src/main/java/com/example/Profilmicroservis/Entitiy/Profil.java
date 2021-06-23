package com.example.Profilmicroservis.Entitiy;


import com.example.Profilmicroservis.Entitiy.Enumeracija.Pol;
import com.example.Profilmicroservis.Entitiy.Enumeracija.Uloga;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profil")
@Data
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
