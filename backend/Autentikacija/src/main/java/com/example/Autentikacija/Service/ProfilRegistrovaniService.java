package com.example.Autentikacija.Service;

import com.example.Autentikacija.Conection.ProfilKonekcija;
import com.example.Autentikacija.DTO.ProfilRegistrovaniDTO;
import com.example.Autentikacija.Entity.ProfilRegistrovani;

import com.example.Autentikacija.Exception.BadRequestException;
import com.example.Autentikacija.Exception.NotFoundException;
import com.example.Autentikacija.Repository.ProfilRegistrovaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.logging.Logger;

@Service
public class ProfilRegistrovaniService implements ProfilRegistrovani1Service {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfilRegistrovaniRepository profilRegistrovaniRepository;

    @Autowired
    private ProfilKonekcija profilKonekcija;

    public ProfilRegistrovani findByUsername(String username) {
        ProfilRegistrovani profilRegistrovani = profilRegistrovaniRepository.findByUsername(username);
        if (profilRegistrovani == null) {
            throw new NotFoundException("Username nije pronadjen " );
        }
        return profilRegistrovani;
    }

    @Override
    public ProfilRegistrovani register(ProfilRegistrovaniDTO profilRegistrovaniDTO) {
        ProfilRegistrovani profilRegistrovani = new ProfilRegistrovani();
        if(profilRegistrovaniRepository.findByUsername(profilRegistrovaniDTO.getUsername()) == null) {
            profilRegistrovani.setUsername(profilRegistrovaniDTO.getUsername());
        } else{
            throw new BadRequestException("username vec postoji");
        }
        profilRegistrovani.setPassword(passwordEncoder.encode(profilRegistrovaniDTO.getPassword()));

        profilRegistrovani.setUloga("KORISNIK");

     /*  try{
            profilKonekcija.registerUser(profilRegistrovaniDTO);
        }catch (Exception e){
            throw new BadRequestException("Neuspesna registracija!");
        }
       */ return profilRegistrovaniRepository.save(profilRegistrovani);

    }

    @Override
    public ProfilRegistrovani login(ProfilRegistrovaniDTO profilRegistrovaniDTO) throws IOException {
        ProfilRegistrovani profilRegistrovani = profilRegistrovaniRepository.findByUsername(profilRegistrovaniDTO.getUsername());
        if (profilRegistrovani == null || !passwordEncoder.matches(profilRegistrovaniDTO.getPassword(), profilRegistrovani.getPassword())) {
            throw new BadRequestException("Neodgovarajuci username ili password.");
        } else {
        return profilRegistrovani;
        }
    }

}
