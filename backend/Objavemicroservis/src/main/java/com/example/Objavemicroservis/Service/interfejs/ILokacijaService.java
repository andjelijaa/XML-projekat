package com.example.Objavemicroservis.Service.interfejs;


import com.example.Objavemicroservis.Entity.Lokacija;

import java.util.List;

public interface ILokacijaService {

    List<Lokacija> getAll();

    Lokacija kreirajLokaciju (Lokacija lokacija);

    Lokacija pronadji_po_ID(Long id);

    Lokacija pronadji_po_imenu(String naziv_mesta);
}

