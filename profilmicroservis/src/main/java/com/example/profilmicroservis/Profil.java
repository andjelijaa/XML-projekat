package com.example.profilmicroservis;


import com.example.profilmicroservis.enumeracija.Pol;
import com.example.profilmicroservis.enumeracija.Uloga;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "Profil")
public class Profil {

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
        private Date datumRodjenja;

        @Column
        private Pol polKorisnika;

        @Column
        private String biografija;

        @Column
        private String websajt;

     //   @Column
       // private Uloga ulogaKorisnika;

        @Column
        private boolean privatniProfil;

}
