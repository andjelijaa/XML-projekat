package com.example.Objavemicroservis.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjavaPodaciService implements IObjavaPodaciService {

    @Autowired
    private ObjavaPodaciRepository objavaPodaciRepository;

    @Autowired
    private ILokacijaService lokacijaService;

    @Autowired
    private IHashtagService tagService;

    @Autowired
    private ObjavaRepository objavaRepository;
//



    @Override
    public List<ObjavaPodaci> getAll() {
        List<ObjavaPodaci> objavaPodacii = objavaPodaciRepository.pronadjiSve();
        //if (objavaPodacii.isEmpty())
//
        return objavaPodacii;
    }

    @Override
    public ObjavaPodaci sacuvaj(ObjavaPodaci objavaPodaci) {

        ObjavaPodaci dbObjavaPodaci = new ObjavaPodaci();

        //

        return dbObjavaPodaci;
    }

    @Override
    public List<ObjavaPodaci> getUserImages(String username) {
        List<ObjavaPodaci> objavaPodaci = objavaPodaciRepository.pronadjiPoObjavaUsername(username);
        //
        return objavaPodacii;
    }



}
