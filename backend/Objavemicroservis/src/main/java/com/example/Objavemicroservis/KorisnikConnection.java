package com.example.Objavemicroservis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-microservice", url = "http://localhost:3032")
public interface KorisnikConnection {

    @PostMapping("/user/are_public")
    List<String> arePublic(@RequestBody List<String> usernames);

    @GetMapping("/user/public_users")
    List<String> getPublicUsers();

}
