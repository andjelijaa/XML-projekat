package com.example.Objavemicroservis.service;


import org.springframework.stereotype.Service;
import org.
import java.util.List;

@Service
public class KomentarService implements iKomentarService {

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
        //
        komentar.setText(komentarDTO.getText());
        KomentarRepository.sacuvaj(komentar);
        //
        List<Komentar> komentari = objavaPodaci.getKomentari();
        komentari.add(komentar);
        //

        return komentar;
    }

}
