package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.DTO.KomentarDTO;
import com.example.Objavemicroservis.Entity.Komentar;
import com.example.Objavemicroservis.Entity.Objava;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import com.example.Objavemicroservis.Repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.Service.interfejs.IKomentarService;
import java.util.List;

@Service
public class KomentarService implements IKomentarService {

    @Autowired
    private KomentarRepository komentarRepository;

    @Override
    public List<Komentar> getAllByPost(Long id) {

        return null;
    }


    @Override
    public Komentar kreirajKomentar(KomentarDTO komentarDTO) {
        Komentar komentar = new Komentar();
        komentar.setUsername(komentarDTO.getUsername());
        komentar.setTekst(komentarDTO.getTekst());
        komentarRepository.sacuvaj(komentar);
     //dodati

        return komentar;
    }

}
