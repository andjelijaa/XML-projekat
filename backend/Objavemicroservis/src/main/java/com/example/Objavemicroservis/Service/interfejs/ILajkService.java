package com.example.Objavemicroservis.service.interfejs;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateLikeDto;
import com.mediamicroservice.mediamicroservice.domain.Like;

import java.util.List;

public interface LajkService {

    Lajk kreirajLajk(LajkDto lajkDto);

    Integer prebrojLajkove(Long id);

    boolean da_li_je_lajkovano(Long id, String username);

    List<Lajk> istorija(String username);
}
