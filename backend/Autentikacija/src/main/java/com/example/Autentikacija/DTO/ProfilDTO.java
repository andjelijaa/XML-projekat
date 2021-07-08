package com.example.Autentikacija.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class ProfilDTO {
    private String username;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private Date datumrodjenja;
    private String webSite;
    private String biografija;

}




