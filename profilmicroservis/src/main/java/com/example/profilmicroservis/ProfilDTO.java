package com.example.profilmicroservis;


import com.example.profilmicroservis.enumeracija.Pol;
import com.example.profilmicroservis.enumeracija.Uloga;
import lombok.Data;

import java.util.Date;

@Data
public class ProfilDTO {
    private String username;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private Pol polKorisnika;
    //private Uloga ulogaKorisnika;
    private Date datumRodjenja;
    private String websajt;
    private String biografija;

}
