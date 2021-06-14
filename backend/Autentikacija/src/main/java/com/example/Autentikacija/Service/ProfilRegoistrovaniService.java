package com.example.Autentikacija.Service;

import com.example.Autentikacija.DTO.ProfilRegistrovaniDTO;
import com.example.Autentikacija.Entity.ProfilRegistrovani;
import com.example.Autentikacija.Repository.ProfilRegistrovaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProfilRegoistrovaniService implements ProfilRegostrovani1Service {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProfilRegistrovaniRepository profilRegistrovaniRepository;
    @Autowired
    private  Uloga1Service ulogaService;


    public ProfilRegistrovani findByUsername(String username) {
        ProfilRegistrovani profilRegistrovani = profilRegistrovaniRepository.findByUsername(username);
        if (profilRegistrovani == null) {
           //  throw new NotFoundException("There is no user credentials with username " + username);
            return null;
        }
        return profilRegistrovani;
    }

    @Override
    public ProfilRegistrovani register(ProfilRegistrovaniDTO profilRegistrovaniDTO) {
        ProfilRegistrovani profilRegistrovani = new ProfilRegistrovani();
        profilRegistrovani.setUsername(profilRegistrovaniDTO.getUsername());
        profilRegistrovani.setPassword(passwordEncoder.encode(profilRegistrovaniDTO.getPassword()));
        profilRegistrovani.setUloge(ulogaService.findByName("ROLE_USER"));
     /*   try{
            userConnection.registerUser(uprofilRegistrovaniDTO);
        }catch (Exception e){
            throw new BadRequestException("Unsuccessfully added user!");
        }*/
        return profilRegistrovaniRepository.save(profilRegistrovani);
    }

    @Override
    public ProfilRegistrovani login(ProfilRegistrovaniDTO profilRegistrovaniDTO) throws IOException {
        ProfilRegistrovani profilRegistrovani = profilRegistrovaniRepository.findByUsername(profilRegistrovaniDTO.getUsername());
        if (profilRegistrovani == null || !passwordEncoder.matches(profilRegistrovaniDTO.getPassword(), profilRegistrovani.getPassword()))
          //  throw new BadRequestException("Username or password is not correct.");
            return null;
        return profilRegistrovani;
    }

}
