package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.DTO.ObjavaDTO;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import com.example.Objavemicroservis.Repository.ObjavaPodaciRepository;
import com.example.Objavemicroservis.Repository.ObjavaRepository;
import com.example.Objavemicroservis.Service.interfejs.IHashtagService;
import com.example.Objavemicroservis.Service.interfejs.ILokacijaService;
import com.example.Objavemicroservis.Service.interfejs.IObjavaPodaciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjavaPodaciService implements IObjavaPodaciService {

    private ObjavaPodaciRepository objavaPodaciRepository;

    private ILokacijaService lokacijaService;

    private IHashtagService tagService;

    private ObjavaRepository objavaRepository;




    @Override
    public List<ObjavaPodaci> getAll() {
        List<ObjavaPodaci> objavaPodacii = objavaPodaciRepository.pronadjiSve();
        return objavaPodacii;
    }

    @Override
    public ObjavaPodaci sacuvaj(ObjavaPodaci objavaPodaci) {

        ObjavaPodaci dbObjavaPodaci = new ObjavaPodaci();
        dbObjavaPodaci = objavaPodaciRepository.sacuvaj(dbObjavaPodaci);

        return dbObjavaPodaci;
    }



    @Override
    public ObjavaPodaci sacuvajSlikaInfo(ObjavaDTO slikaDto) {
        return null;
    }

    @Override
    public ObjavaPodaci getById(Long id) {
        return null;
    }

    @Override
    public List<ObjavaPodaci> getJavneObjave() {
        return null;
    }

    @Override
    public List<ObjavaPodaci> getKorisnikSlike(String username) {
        List<ObjavaPodaci> objavaPodaci = objavaPodaciRepository.pronadjiPoObjavaUsername(username);

        return objavaPodaci;
    }



}
