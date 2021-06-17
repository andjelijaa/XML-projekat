package com.example.Profilmicroservis.Service;


import com.example.Profilmicroservis.Entitiy.Profil;
import com.example.Profilmicroservis.Repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilService {


    @Autowired
    private ProfilRepository profilRepository;

}
