package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.Entity.Lokacija;
import com.example.Objavemicroservis.Repository.LokacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.Service.interfejs.ILokacijaService;
import java.util.List;
import java.util.Optional;

@Service
public class LokacijaService implements ILokacijaService {


    private LokacijaRepository lokacijaRepository;

    @Override
    public List<Lokacija> getAll() {
        List<Lokacija> lokacije = lokacijaRepository.findAll();
        return lokacije;
        //
    }

    @Override
    public Lokacija create(Lokacija lokacija) {
        Lokacija dbLokacija = new Lokacija();

        return dbLokacija;
    }

    @Override
    public Lokacija findById(Long id) {
   /*     Lokacija lokacija = lokacijaRepository.findAllById(id);
        //
        return lokacija;
   */ return  null;
    }

    @Override
    public Lokacija findByName(String naziv_mesta) {

          Lokacija lokacija = lokacijaRepository.findByName(naziv_mesta);
//        if (lokacija == null)

        return lokacija;
    }
}