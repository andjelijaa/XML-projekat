package com.example.Autentikacija.DTO;


import lombok.Data;

@Data
public class ProfilRegistrovaniDTO {
    private String username;
    private String ime;
    private  String prezime;
    private String email;
    private String password;

}
