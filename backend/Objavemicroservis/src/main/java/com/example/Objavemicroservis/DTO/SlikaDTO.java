package com.example.Objavemicroservis.DTO;

import com.example.Objavemicroservis.Entity.Hashtag;
import com.example.Objavemicroservis.Entity.Komentar;
import com.example.Objavemicroservis.Entity.Lajk;
import com.example.Objavemicroservis.Entity.Lokacija;
import lombok.Data;

import java.util.List;

@Data
public class SlikaDTO {
    private Long id;
    private String username;
    private String opis;
    private Lokacija lokacija;
    private List<Hashtag> hashtagovi;
    private List<Komentar> komentari;
    private boolean da_li_je_slika;
    private List<Lajk> lajkovi;
    private List<byte[]> kodSlike;
}
