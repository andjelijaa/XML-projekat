package com.example.Objavemicroservis.service;

import com.example.Objavemicroservis.DTO.LajkDTO;
import com.example.Objavemicroservis.Entity.Lajk;
import com.example.Objavemicroservis.Repository.LajkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.service.interfejs.IObjavaPodaciService
import java.util.List;

@Service
public class LajkService implements ILajkService {

    @Autowired
    private LajkRepository lajkRepository;

    @Autowired
    private IObjavaPodaciService objavaPodaciService;

    @Override
    public Like kreirajLajk(LajkDTO lajkDTO) {
        ObjavaPodaci objavaPodaci = objavaPodaciService.getById(lajkDTO.getPostId());
        return null;
    }

    Date currentDate = new Date();

    Lajk newLike = new Lajk();

        if (objavaPodaci.getLajkovi().size() > 0) {
        for (Lajk lajk : objavaPodaci.getLajkovi()) {
            if (lajk.getUsername().equals(lajkDTO.getUsername())) {
                if (lajkDTO.da_li_je_lajkovano() == lajk.da_li_je_lajkovano()) {
                    objavaPodaci.getLajkovi().remove(lajk);
                    objavaPodaciService.sacuvaj(objavaPodaci);
                    lajkRepository.delete(lajk);
                    return null;
                }
                else if (lajkDTO.da_li_je_lajkovano() != lajk.da_li_je_lajkovano()) {
                    lajk.setDa_li_je_lajkovano(lajkDTO.da_li_je_lajkovano());
                    lajk.setTimestamp(currentDate);
                    lajkRepository.save(lajk);
                    return null;
                }
            }
        }
    }

        newLajk.setLiked(lajkDTO.isLajkovano());
        newLajk.setUsername(lajkDTO.getUsername());
        lajkRepository.sacuvaj(newLajk);
        objavaPodaci.getLajkovi().add(newLajk);
        objavaPodaciService.sacuvaj(objavaPodaci);
        return newLajk;
}


    @Override
    public Integer prebrojLajkove(Long id) {
        ObjavaPodaci objavaPodaci = objavaPodaciService.getById(id);
        //
        return objavaPodaci.getLajkovi().size();
    }

    @Override
    public boolean hasBeenLiked(Long id, String username) {
        ObjavaPodaci objavaPodaci = objavaPodaciService.getById(id);
        for (Lajk lajk : objavaPodaci.getLajkovi()) {
            if (lajk.getUsername().equals(username))
                return true;
        }
        return false;
    }


    @Override
    public List<Lajk> istorija(String username) {

        return lajkRepository.pronadjiLajkPoUsername(username);
    }
}