package com.example.Objavemicroservis.service.interfejs;


import java.util.List;

public interface IObjavaPodaciService {

    List<ObjavaPodaci> getAll();

    ObjavaPodaci sacuvaj(ObjavaPodaci objavaPodaci);

    List<ObjavaPodaci> getKorisnikSlike(String username);

    ObjavaPodaci sacuvajSlikaInfo(ObjavaDTO slikaDto);

    ObjavaPodaci getById(Long id);

    List<ObjavaPodaci> getJavneObjave();
}
