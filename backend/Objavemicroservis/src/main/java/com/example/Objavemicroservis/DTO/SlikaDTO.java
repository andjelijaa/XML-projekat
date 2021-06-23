package com.example.Objavemicroservis.DTO;

import lombok.Data;

@Data
public class SlikaDTO {
    private Long id;
    private String username;
    private String opis;
    private Location lokacija;
    private List<Hashtag> hashtagovi;
    private List<Komentar> komentari;
    private boolean da_li_je_slika;
    private List<Lajk> lajkovi;
    private List<byte[]> kodSlike;
}
