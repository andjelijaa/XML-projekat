package com.example.Objavemicroservis.service;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateLikeDto;
import com.mediamicroservice.mediamicroservice.domain.Like;

import java.util.List;

@Service
public class LokacijaService implements ILokacijaService {

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Override
    public List<Lokacija> getAll() {
        List<Lokacija> lokacije = lokacijaRepository.pronadjiSveAll();
        return lokacije;
        //
    }

    @Override
    public Lokacija kreirajLokaciju(Lokacija lokacija) {
        Lokacija dbLokacija = new Lokacija();
        //
        return dbLokacija;
    }

    @Override
    public Lokacija pronadji_po_ID(Long id) {
        Lokacija lokacija = lokacijaRepository.pronadji_po_ID(id);
        //
        return lokacija;
    }

    @Override
    public Lokacija pronadji_po_imenu(String naziv_mesta) {

        Lokacija lokacija = lokacijaRepository.pronadji_po_imenu(naziv_mesta);
//        if (lokacija == null)

        return lokacija;
    }
}