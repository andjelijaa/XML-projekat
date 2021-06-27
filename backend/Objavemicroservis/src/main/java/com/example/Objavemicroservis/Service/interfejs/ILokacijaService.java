package com.example.Objavemicroservis.Service.interfejs;


import com.example.Objavemicroservis.Entity.Lokacija;

import java.util.List;

public interface ILokacijaService {

    List<Lokacija> getAll();

    Lokacija create(Lokacija lokacija);

    Lokacija findById(Long id);

    Lokacija findByName(String naziv_mesta);
}



