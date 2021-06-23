package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.Entity.Lokacija;
import com.example.Objavemicroservis.Repository.LokacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.Service.interfejs.ILokacijaService;
import java.util.List;

@Service
public class LokacijaService implements ILokacijaService {

    private LokacijaRepository lokacijaRepository;

    @Override
    public List<Lokacija> getAll() {
        List<Lokacija> lokacije = lokacijaRepository.pronadjiSve();
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