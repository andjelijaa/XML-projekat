package com.example.Profilmicroservis.Service;


import com.example.Profilmicroservis.Entitiy.Profil;
import com.example.Profilmicroservis.Repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilService implements Profil1Service{


    @Autowired
    private ProfilRepository profilRepository;

    public List<Profil> getAll() {
        List<Profil> profili = profilRepository.findAll();
        return profili;
    }





}
