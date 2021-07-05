package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.Connection.ProfilKonekcija;
import com.example.Objavemicroservis.DTO.ObjavaDTO;
import com.example.Objavemicroservis.DTO.SlikaDTO;
import com.example.Objavemicroservis.Entity.Hashtag;
import com.example.Objavemicroservis.Entity.Lokacija;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import com.example.Objavemicroservis.ObjavaMapper;
import com.example.Objavemicroservis.Repository.ObjavaPodaciRepository;
import com.example.Objavemicroservis.Service.interfejs.IHashtagService;
import com.example.Objavemicroservis.Service.interfejs.ILokacijaService;
import com.example.Objavemicroservis.Service.interfejs.IObjavaPodaciService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;

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
    private  ProfilKonekcija profilKonekcija;

    @Autowired
    private IHashtagService tagService;


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
        novaObjavaPodaci = objavaPodaciRepository.save(objavaPodaci);

        return novaObjavaPodaci;
    }

    @Override
    public SlikaDTO slikaFile(ObjavaPodaci objavaPodaci, String filePath) {
        SlikaDTO slikaDTO = ObjavaMapper.mapObjavaPodaciToSlikaDTO(objavaPodaci);
        File in = new File(filePath + objavaPodaci.getNazivFajla());
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
            usernames.add(objavaPodaci.getUsername());
        }
        Set<String> set = new HashSet<>(usernames);
        usernames = set.stream().collect(Collectors.toList());
        return usernames;
    }

    private List<ObjavaPodaci> filterJavneObjavePodaciByUsernames(List<String> usernames, List<ObjavaPodaci> objavePodaci) {
        List<ObjavaPodaci> javneObjavePodaci = new ArrayList<>();
        for (ObjavaPodaci objavaPodaci : objavePodaci) {
            for (String username : usernames) {
                if (objavaPodaci.getUsername().equals(username))
                    javneObjavePodaci.add(objavaPodaci);
            }
        }
        Set<ObjavaPodaci> set = new HashSet<>(javneObjavePodaci);
        javneObjavePodaci = set.stream().collect(Collectors.toList());
        return javneObjavePodaci;
    }

    @Override
    public List<SlikaDTO> pretraziTag(String tag) {
        List<ObjavaPodaci> sveObjavePodaci = findAll();
        List<ObjavaPodaci> objavePodaci = new ArrayList<>();
        for (ObjavaPodaci objavaPodaci : sveObjavePodaci) {
            for (Hashtag hashtag : objavaPodaci.getHashtagovi()) {
                if (hashtag.getNazivhashtaga().toLowerCase().contains(tag.toLowerCase()))
                    objavePodaci.add(objavaPodaci);
            }
        }
        List<String> publicProfiles = profilKonekcija.javniProfili(getUsernamesByPost(objavePodaci));
        objavePodaci = filterJavneObjavePodaciByUsernames(publicProfiles, objavePodaci);
        return getSlikeFiles(objavePodaci);
    }

    @Override
    public List<ObjavaPodaci> getJavneObjave() {
        List<ObjavaPodaci> objavePodaci = findAll();
        List<String> usernames = profilKonekcija.getPublicProfil();
        return filterJavneObjavePodaciByUsernames(usernames, objavePodaci);

    }



}
