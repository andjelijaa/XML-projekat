package com.example.Objavemicroservis.service.interfejs;


import java.util.List;

public interface IKomentarService {

    List<Komentar> getAllByPost(Long id);

    Komentar kreirajKomentar(KomentarDTO komentarDTO);
}
