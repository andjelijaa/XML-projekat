package com.example.Autentikacija.Service;

import com.example.Autentikacija.DTO.ProfilRegistrovaniDTO;
import com.example.Autentikacija.Entity.ProfilRegistrovani;

import java.io.IOException;

public interface ProfilRegistrovani1Service {
    ProfilRegistrovani findByUsername(String username);
    ProfilRegistrovani register(ProfilRegistrovaniDTO profilRegostrovani);
    ProfilRegistrovani login(ProfilRegistrovaniDTO profilRegistrovaniDTO) throws IOException;

}
