package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.DTO.ObjavaDTO;
import com.example.Objavemicroservis.DTO.SlikaDTO;
import com.example.Objavemicroservis.Entity.Lokacija;
import com.example.Objavemicroservis.Entity.Objava;
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
        List<ObjavaPodaci> objavaPodacii = objavaPodaciRepository.findAll();
        return objavaPodacii;
    }

    @Override
    public ObjavaPodaci save(ObjavaPodaci objavaPodaci) {

        ObjavaPodaci novaObjavaPodaci = new ObjavaPodaci();
        novaObjavaPodaci = objavaPodaciRepository.save(novaObjavaPodaci);

        return novaObjavaPodaci;
    }


    @Override
    public ObjavaPodaci sacuvajSlikaInfo(ObjavaDTO slikaDto) {
        ObjavaPodaci objavaPodaci = new ObjavaPodaci();
        Objava objava = new Objava();
        objava.setNazivFajla(slikaDto.getNazivFajla());
        if (slikaDto.getNazivFajla().contains(".mp4")) {
            objava.setDa_li_je_slika(false);
        }
        objava.setUsername(slikaDto.getUsername());
        objava.setOpis(slikaDto.getOpis());
        Lokacija lokacija = lokacijaService.findByName(slikaDto.getNazivLokacije());
        objava.setLokacija(lokacija);
        objava.setHashtagovi(tagService.kreirajHashTag(slikaDto.getTagovi()));
        objavaRepository.save(objava);
        objavaPodaci.setObjava(objava);
        return save(objavaPodaci);
    }

    @Override
    public ObjavaPodaci getById(Long id) {
        ObjavaPodaci objavaPodaci = objavaPodaciRepository.findObjavaPodaciById(id);
        if (objavaPodaci== null)
            return null;
        return objavaPodaci;

    }

    /* ovo treba da stoji u objava repo a ne objava podaci repo !
    @Override
    public List<ObjavaPodaci> pretraziLokaciju(String lokacija) {
        List<ObjavaPodaci> objavaPodacii = objavaPodaciRepository.findByLokacija(lokacija);
        return objavaPodacii;
        //
    } */

    @Override
    public List<ObjavaPodaci> pretraziTag(String tag) {
        //TODO
        return null;
    }

    @Override
    public List<ObjavaPodaci> getJavneObjave() {
//        List<ObjavaPodaci> objavaPodacii = findAll();
//        return filterPublicPostByUsernames(usernames, posts);
        //TODO
        return null;
    }

    @Override
    public List<ObjavaPodaci> pretraziLokaciju(String lokacija) {
        return null;
    }


}
