package com.example.Objavemicroservis.Service;

import com.example.Objavemicroservis.DTO.LajkDTO;
import com.example.Objavemicroservis.Entity.Lajk;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import com.example.Objavemicroservis.Repository.LajkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.Service.interfejs.IObjavaPodaciService;
import com.example.Objavemicroservis.Service.interfejs.ILajkService;

import java.util.Date;
import java.util.List;

@Service
public class LajkService implements ILajkService {

    @Autowired
    private LajkRepository lajkRepository;


    @Autowired
    private IObjavaPodaciService objavaPodaciService;

    @Override
    public Lajk kreirajLajk(LajkDTO lajkDTO) {
        ObjavaPodaci objavaPodaci = objavaPodaciService.getById(lajkDTO.getObjavaID());
        Lajk noviLajk = new Lajk();
        if (objavaPodaci.getLajkovi().size() > 0) {
            for (Lajk lajk : objavaPodaci.getLajkovi()) {
                if (lajk.getUsername().equals(lajkDTO.getUsername())) {
                    if (lajkDTO.isLajkovano() == lajk.isLajkovano()) {
                        objavaPodaci.getLajkovi().remove(lajk);
                        objavaPodaciService.save(objavaPodaci);
                        lajkRepository.delete(lajk);
                        return null;
                    } else if (lajkDTO.isLajkovano() != lajk.isLajkovano()) {
                        lajk.setLajkovano(lajkDTO.isLajkovano());
                        lajkRepository.save(lajk);
                        return null;
                    }
                }
            }
        }

        noviLajk.setLajkovano(lajkDTO.isLajkovano());
        noviLajk.setUsername(lajkDTO.getUsername());
        lajkRepository.save(noviLajk);
        objavaPodaci.getLajkovi().add(noviLajk);
        objavaPodaciService.save(objavaPodaci);
        return noviLajk;
    }


    @Override
    public Integer prebrojLajkove(Long id) {
        ObjavaPodaci objavaPodaci = objavaPodaciService.getById(id);
        return objavaPodaci.getLajkovi().size();
    }

    @Override
    public boolean da_li_je_lajkovano(Long id, String username) {
        ObjavaPodaci objavaPodaci = objavaPodaciService.getById(id);
        for (Lajk lajk : objavaPodaci.getLajkovi()) {
            if (lajk.getUsername().equals(username))
                return true;
        }
        return false;
    }


    @Override
    public List<Lajk> history(String username) {

        return lajkRepository.findLajkByUsername(username);
    }
}