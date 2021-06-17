package com.example.Profilmicroservis.Service;


import com.example.Profilmicroservis.Entitiy.DTO.ProfilRegistrovaniDTO;
import com.example.Profilmicroservis.Entitiy.Profil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Profil1Service {

    List<Profil> getAll();

    List<Profil> search(String username);

    Profil findUserByUsername(String username);

    Profil findUserByEmail(String email);

  //  Profil registerUser(ProfilRegistrovaniDTO userReg, boolean isGoogleUser);
  Profil save(Profil profil);
   // Profil updateUser(Profil profil, String oldUsername);



}
