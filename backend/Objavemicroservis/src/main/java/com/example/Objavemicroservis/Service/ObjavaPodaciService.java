package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.Connection.ProfilKonekcija;
import com.example.Objavemicroservis.DTO.ObjavaDTO;
import com.example.Objavemicroservis.DTO.SlikaDTO;
import com.example.Objavemicroservis.Entity.Hashtag;
import com.example.Objavemicroservis.Entity.Lokacija;
import com.example.Objavemicroservis.Entity.Objava;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;
<<<<<<< HEAD
<<<<<<< HEAD
import com.example.Objavemicroservis.FileUpload;
=======
import com.example.Objavemicroservis.ObjavaMapper;
>>>>>>> 43f5ce5e65231f078663ef565c8c1bbb85b268d6
=======

>>>>>>> 515c32dd509ecbebdaa58d83f2356f6da865d8ec
import com.example.Objavemicroservis.Repository.ObjavaPodaciRepository;
import com.example.Objavemicroservis.Repository.ObjavaRepository;
import com.example.Objavemicroservis.Service.interfejs.IHashtagService;
import com.example.Objavemicroservis.Service.interfejs.ILokacijaService;
import com.example.Objavemicroservis.Service.interfejs.IObjavaPodaciService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
=======
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
>>>>>>> 43f5ce5e65231f078663ef565c8c1bbb85b268d6
=======

>>>>>>> 515c32dd509ecbebdaa58d83f2356f6da865d8ec
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    private static String upload = "profil-slike";

    @Override
    public List<ObjavaPodaci> getAll() {
        List<ObjavaPodaci> objavaPodacii = objavaPodaciRepository.findAll();
        return objavaPodacii;
    }

    private List<ObjavaPodaci> findAll() {
        List<ObjavaPodaci> objavePodaci = objavaPodaciRepository.findAll();
        if (objavePodaci.isEmpty())
            return null;
        return objavePodaci;
    }

    @Override
    public ObjavaPodaci save(ObjavaPodaci objavaPodaci) {

        ObjavaPodaci novaObjavaPodaci = new ObjavaPodaci();
        novaObjavaPodaci = objavaPodaciRepository.save(novaObjavaPodaci);

        return novaObjavaPodaci;
    }

    @Override
    public SlikaDTO slikaFile(ObjavaPodaci objavaPodaci, String filePath) {
        SlikaDTO slikaDTO = ObjavaMapper.mapObjavaPodaciToSlikaDTO(objavaPodaci);
        File in = new File(filePath + objavaPodaci.getObjava().getNazivFajla());
        try {
            slikaDTO.getKodSlike().add(IOUtils.toByteArray(new FileInputStream(in)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return slikaDTO;
    }

    @Override
    public List<SlikaDTO> getSlikeFiles(List<ObjavaPodaci> objavePodaci) {
        List<SlikaDTO> slikaDto = new ArrayList<>();
        if (objavePodaci != null) {
            String filePath = new File("").getAbsolutePath();
            filePath = filePath.concat("/" + upload + "/");
            for (ObjavaPodaci objavaPodaci : objavePodaci) {
                slikaDto.add(slikaFile(objavaPodaci, filePath));
            }
        }
        return slikaDto;
    }

    @Override
    public ObjavaPodaci sacuvajSlikaInfo(ObjavaDTO slikaDto) {
        ObjavaPodaci objavaPodaci = new ObjavaPodaci();
        objavaPodaci.setNazivFajla(slikaDto.getNazivFajla());
        objavaPodaci.setUsername(slikaDto.getUsername());
        objavaPodaci.setOpis(slikaDto.getOpis());
        Lokacija lokacija = lokacijaService.findByName(slikaDto.getNazivLokacije());
        objavaPodaci.setLokacija(lokacija);
        objavaPodaci.setHashtagovi(tagService.kreirajHashTag(slikaDto.getTagovi()));
        objavaPodaciRepository.save(objavaPodaci);

        return save(objavaPodaci);
    }



    @Override
    public ObjavaPodaci getById(Long id) {
        ObjavaPodaci objavaPodaci = objavaPodaciRepository.findObjavaPodaciById(id);
        return objavaPodaci;

    }


    @Override
    public List<SlikaDTO> pretraziLokaciju(String lokacija) {
        List<ObjavaPodaci> objavePodaci = objavaPodaciRepository.findObjavaPodaciByLokacija(lokacija);
        return getSlikeFiles(objavePodaci);
    }

    private List<String> getUsernamesByPost(List<ObjavaPodaci> objavePodaci) {
        List<String> usernames = new ArrayList<>();
        for (ObjavaPodaci objavaPodaci : objavePodaci) {
            usernames.add(objavaPodaci.getObjava().getUsername());
        }
        Set<String> set = new HashSet<>(usernames);
        usernames = set.stream().collect(Collectors.toList());
        return usernames;
    }

    @Override
    public List<SlikaDTO> pretraziTag(String tag) {
        List<ObjavaPodaci> sveObjavePodaci = findAll();
        List<ObjavaPodaci> objavePodaci = new ArrayList<>();
        for (ObjavaPodaci objavaPodaci : sveObjavePodaci) {
            for (Hashtag hashtag : objavaPodaci.getObjava().getHashtagovi()) {
                if (hashtag.getNazivhashtaga().toLowerCase().contains(tag.toLowerCase()))
                    objavePodaci.add(objavaPodaci);
            }
        }
//        List<String> publicProfiles = ProfilKonekcija.javniProfili(getUsernamesByPost(objavePodaci));
        return getSlikeFiles(objavePodaci);
    }

    @Override
    public List<ObjavaPodaci> getJavneObjave() {
        //TODO
        return null;
    }



}
