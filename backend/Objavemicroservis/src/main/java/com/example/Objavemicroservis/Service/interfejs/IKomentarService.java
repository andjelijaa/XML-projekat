package com.example.Objavemicroservis.service.interfejs;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateLikeDto;
import com.mediamicroservice.mediamicroservice.domain.Like;

import java.util.List;

public interface IKomentarService {

    List<Komentar> getAllByPost(Long id);

    Komentar kreirajKomentar(KomentarDTO komentarDTO);
}
