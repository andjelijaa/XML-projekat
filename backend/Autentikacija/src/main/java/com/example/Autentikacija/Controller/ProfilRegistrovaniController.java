package com.example.Autentikacija.Controller;


import com.example.Autentikacija.DTO.ProfilRegistrovaniDTO;
import com.example.Autentikacija.Entity.ProfilRegistrovani;
import com.example.Autentikacija.Security.jwtService;
import com.example.Autentikacija.Service.ProfilRegistrovaniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/profilRegistrovanog")
@RestController
public class ProfilRegistrovaniController {
    @Autowired
    private ProfilRegistrovaniService profilRegistrovaniService;

    @Autowired
    private jwtService jwtService;


    @PostMapping("/add")
    public void register(@RequestBody ProfilRegistrovaniDTO profilReg) {
        profilRegistrovaniService.register(profilReg);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ProfilRegistrovaniDTO profil) throws IOException {

        ProfilRegistrovani profilReg = profilRegistrovaniService.login(profil);

        String jwt = jwtService.createToken(profilReg.getUsername());

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

}
