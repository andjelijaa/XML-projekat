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

   @Autowired
    private LokacijaRepository lokacijaRepository;

    @Override
    public List<Lokacija> getAll() {
        List<Lokacija> lokacije = lokacijaRepository.findAll();
        return lokacije;
    }

    @Override
    public Lokacija create(Lokacija lokacija) {
        Lokacija novaLokacija = new Lokacija();
        return novaLokacija;
    }

    @Override
    public Lokacija findById(Long id) {
        Lokacija lokacija = lokacijaRepository.findLokacijaById(id);

        return lokacija;
    }

    @Override
    public Lokacija findByName(String naziv_mesta) {

          Lokacija lokacija = lokacijaRepository.findByName(naziv_mesta);

          return lokacija;
    }
}