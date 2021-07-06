package com.example.Profilmicroservis.Service;


import com.example.Profilmicroservis.Entitiy.DTO.ProfilRegistrovaniDTO;
import com.example.Profilmicroservis.Entitiy.Profil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Profil1Service {

    List<Profil> getAll();

    List<Profil> pretraga(String username);

    Profil findUserByUsername(String username);

    Profil findUserByEmail(String email);

    Profil register(ProfilRegistrovaniDTO profilReg);

    Profil sacuvaj(Profil profil);



}
