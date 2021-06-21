package com.example.Profilmicroservis.Controller;


import com.example.Profilmicroservis.Entitiy.DTO.ProfilDTO;
import com.example.Profilmicroservis.Entitiy.DTO.ProfilRegistrovaniDTO;
import com.example.Profilmicroservis.Service.Profil1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("profil")
@CrossOrigin(origins = "https://localhost:3000")
@RestController
public class ProfilController {

    @Autowired
    private Profil1Service profil1Service;


    @PostMapping("/add")
    public void registerUser(@RequestBody ProfilRegistrovaniDTO profilRegistrovani) {
        profil1Service.registerProfil(profilRegistrovani);
    }



}
