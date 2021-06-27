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

    private LajkRepository lajkRepository;

    private IObjavaPodaciService objavaPodaciService;

    @Override
    public Lajk kreirajLajk(LajkDTO lajkDTO) {
        ObjavaPodaci objavaPodaci = objavaPodaciService.getById(lajkDTO.getObjavaID());
        return null;
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