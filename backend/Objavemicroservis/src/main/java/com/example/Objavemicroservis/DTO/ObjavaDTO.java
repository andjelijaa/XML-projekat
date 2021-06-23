package com.example.Objavemicroservis.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ObjavaDTO {
    private String nazivFajla;

    private String opis;

    private String nazivLokacije;

    private List<String> tagovi;

    private String username;
}
