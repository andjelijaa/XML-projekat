package com.example.Autentikacija.Conection;


import com.example.Autentikacija.DTO.ProfilDTO;
import com.example.Autentikacija.DTO.ProfilRegistrovaniDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

<<<<<<< HEAD
@FeignClient(name = "Profilmicroservis")
=======

@FeignClient(value = "Profilmicroservis", url = "http://Profilmicroservis:7877")
>>>>>>> 2c2fdb899e4d9c6c56a47d2b003f5c38d3b08863
public interface ProfilKonekcija {

    @PostMapping("/profil/add")
    void register(@RequestBody ProfilRegistrovaniDTO profilRegistrovaniDTO);

    @PostMapping("/profil/find")
    ProfilDTO getProfilByEmail(@RequestBody String email);


}
