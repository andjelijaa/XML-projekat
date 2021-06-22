package com.example.Profilmicroservis.Entitiy.DTO;

import com.example.Profilmicroservis.Entitiy.Enumeracija.Pol;
import com.example.Profilmicroservis.Entitiy.Enumeracija.Uloga;
import lombok.Data;

import java.util.Date;

@Data
public class ProfilDTO {
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private Pol pol;
    private Date datumrodjenja;
    private String username;
    private String webSite;
    private String biografija;
    private Uloga uloga;


}
