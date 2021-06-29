package com.example.Autentikacija.Conection;


import com.example.Autentikacija.DTO.ProfilDTO;
import com.example.Autentikacija.DTO.ProfilRegistrovaniDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "Profilmicroservis", url = "http://localhost:7870")
public interface ProfilKonekcija {

    @PostMapping("/profil/add")
    void registerUser(@RequestBody ProfilRegistrovaniDTO profilRegistrovaniDTO);

    @PostMapping("/profil/find")
    ProfilDTO getProfilByEmail(@RequestBody String email);


}
