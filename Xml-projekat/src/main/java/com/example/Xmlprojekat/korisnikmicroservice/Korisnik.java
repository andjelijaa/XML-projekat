package com.example.Xmlprojekat.korisnikmicroservice;


import com.example.Xmlprojekat.Enumeracija.Pol;
import com.example.Xmlprojekat.Enumeracija.Uloga;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Korisnik")
@Entity
@Data

public class Korisnik {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column
        private String ime;

        @Column
        private String prezime;

        @Column(nullable = false)
        private String email;

        @Column
        private String telefon;

        @Column
        private String webSite;

        @Column
        private Date datumRodjenja;

        @Column
        private Pol polKorisnika;

        @Column
        private Uloga ulogaKorisnika;

        @OneToMany(mappedBy = "following")
       // private List<FollowingList> followingList;

        @OneToOne
       // private VerificationRequest verificationRequest;

        @Column
        private boolean javniProfil = false;

        @Column
        private boolean javniDM = true;

        @Column
        private boolean taggable = true;

    }
