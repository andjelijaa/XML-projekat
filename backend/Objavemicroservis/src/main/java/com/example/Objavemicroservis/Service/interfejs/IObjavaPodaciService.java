package com.example.Objavemicroservis.Service.interfejs;


import com.example.Objavemicroservis.DTO.ObjavaDTO;
import com.example.Objavemicroservis.DTO.SlikaDTO;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;

import java.util.List;

public interface IObjavaPodaciService {

    List<ObjavaPodaci> getAll();

    ObjavaPodaci save(ObjavaPodaci objavaPodaci);

    ObjavaPodaci sacuvajSlikaInfo(ObjavaDTO slikaDto);

    ObjavaPodaci getById(Long id);

    List<ObjavaPodaci> getJavneObjave();

    List<ObjavaPodaci> pretraziLokaciju(String lokacija);

    List<ObjavaPodaci> pretraziTag(String tag);
}
