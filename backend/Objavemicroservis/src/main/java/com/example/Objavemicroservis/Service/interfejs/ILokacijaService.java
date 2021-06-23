package com.example.Objavemicroservis.service.interfejs;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateLikeDto;
import com.mediamicroservice.mediamicroservice.domain.Like;

import java.util.List;

public interface ILokacijaService {

    List<Lokacija> getAll();

    Lokacija kreirajLokaciju (Lokacija lokacija);

    Lokacija pronadji_po_ID(Long id);

    Lokacija pronadji_po_imenu(String naziv_mesta);
}

