package com.example.Autentikacija.DTO;


import lombok.Data;

@Data
public class ProfilRegistrovaniDTO {
    private String ime;
    private String prezime;
    private String username;
    private String email;
    private String password;
}
