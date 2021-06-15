package com.example.Autentikacija.Service;

import com.example.Autentikacija.DTO.ProfilRegistrovaniDTO;
import com.example.Autentikacija.Entity.ProfilRegistrovani;

import com.example.Autentikacija.Exception.BadRequestException;
import com.example.Autentikacija.Exception.NotFoundException;
import com.example.Autentikacija.Repository.ProfilRegistrovaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ProfilRegoistrovaniService implements ProfilRegostrovani1Service {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfilRegistrovaniRepository profilRegistrovaniRepository;

    @Autowired
    private  Uloga1Service ulogaService;

    private final RestTemplate restTemplate;

    @Autowired
    public ProfilRegoistrovaniService() {
        this.restTemplate = new RestTemplate();
    }

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
        profilRegistrovani.setUsername(profilRegistrovaniDTO.getUsername());
        profilRegistrovani.setPassword(passwordEncoder.encode(profilRegistrovaniDTO.getPassword()));
        profilRegistrovani.setUloge(ulogaService.findByName("ROLE_USER"));
       try{
           restTemplate.exchange("http://localhost:2222/profil-api/add",
                   HttpMethod.POST, new HttpEntity<>(profilRegistrovaniDTO, new HttpHeaders()), ResponseEntity.class);
        }catch (Exception e){
            throw new BadRequestException("Neuspesna registracija!");
        }
        return profilRegistrovaniRepository.save(profilRegistrovani);
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
