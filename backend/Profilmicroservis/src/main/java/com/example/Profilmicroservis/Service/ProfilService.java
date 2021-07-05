package com.example.Profilmicroservis.Service;


import com.example.Profilmicroservis.Entitiy.DTO.ProfilRegistrovaniDTO;
import com.example.Profilmicroservis.Entitiy.Profil;
import com.example.Profilmicroservis.Repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfilService implements  Profil1Service {

    private ProfilRepository profilRepository;

    @Override
    public List<Profil> getAll() {
        List<Profil> profili= profilRepository.findAll();
        return profili;
    }

    @Override
    public List<Profil> pretraga(String username) {
        return null;
    }


    @Override
    public Profil findUserByUsername(String username) {
        Profil profil = profilRepository.findByUsername(username);
        return profil;
    }

    @Override
    public Profil findUserByEmail(String email) {
        Profil profil= profilRepository.findByEmail(email);
        return profil;
    }

    @Override
    public Profil registerProfil(ProfilRegistrovaniDTO profilReg) {

        return null;
    }

    @Override
    public Profil sacuvaj(Profil profil) {
        Profil profil1 = new Profil();
        profil1 = profilRepository.save(profil1);
        return profil1;
    }
}
