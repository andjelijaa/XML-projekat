package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.DTO.KomentarDTO;
import com.example.Objavemicroservis.Entity.Komentar;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.Service.interfejs.IKomentarService;
import java.util.List;
import com.example.Objavemicroservis.Repository.KomentarRepository;

@Service
public class KomentarService implements IKomentarService {


    @Autowired
     private KomentarRepository komentarRepository;

    @Autowired
    private  ObjavaPodaciService objavaPodaciService;

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
        ObjavaPodaci objavaPodaci= objavaPodaciService.getById(komentarDTO.getObjavaID());
        List<Komentar> komentars=objavaPodaci.getKomentari();
        komentars.add(komentar);
        objavaPodaciService.save(objavaPodaci);
        return komentar;
    }

}
