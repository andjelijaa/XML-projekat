package com.example.Objavemicroservis.Service.interfejs;

import com.example.Objavemicroservis.DTO.LajkDTO;
import com.example.Objavemicroservis.Entity.Lajk;

import java.util.List;

public interface ILajkService {

    Lajk kreirajLajk(LajkDTO lajkDto);

    Integer prebrojLajkove(Long id);

    boolean da_li_je_lajkovano(Long id, String username);

    List<Lajk> istorija(String username);
}
