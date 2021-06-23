package com.example.Objavemicroservis.Service.interfejs;


import com.example.Objavemicroservis.DTO.KomentarDTO;
import com.example.Objavemicroservis.Entity.Komentar;

import java.util.List;

public interface IKomentarService {

    List<Komentar> getAllByPost(Long id);

    Komentar kreirajKomentar(KomentarDTO komentarDTO);
}
