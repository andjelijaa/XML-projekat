package com.example.Objavemicroservis.Connection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Profilmicroservis")
public interface ProfilKonekcija {

    @PostMapping("/profil/javniprofili")
    List<String> javniProfili(@RequestBody List<String> usernames);

    @GetMapping("/profil/public_profil")
    List<String> getPublicProfil();


}
