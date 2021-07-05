package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.DTO.KomentarDTO;
import com.example.Objavemicroservis.Entity.Komentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.Service.interfejs.IKomentarService;
import java.util.List;
import com.example.Objavemicroservis.Repository.KomentarRepository;

@Service
public class KomentarService implements IKomentarService {


    @Autowired
     private KomentarRepository komentarRepository;

    @Override
    public List<Komentar> getAllByPost(Long id) {
        List<Komentar> komentari = komentarRepository.findAll();
        return komentari;
    }


    @Override
    public Komentar kreirajKomentar(KomentarDTO komentarDTO) {
        Komentar komentar = new Komentar();
        komentar.setUsername(komentarDTO.getUsername());
        komentar.setTekst(komentarDTO.getTekst());
        komentarRepository.save(komentar);
     //dodati

        return komentar;
    }

}
