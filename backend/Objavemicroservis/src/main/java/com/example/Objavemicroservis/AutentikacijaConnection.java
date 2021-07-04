package com.example.Objavemicroservis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "authentication-microservice", url = "http://localhost:3031")
public interface AutentikacijaConnection {
    @GetMapping("/verify/{username}")
    String verifyUser(@PathVariable String username);
}