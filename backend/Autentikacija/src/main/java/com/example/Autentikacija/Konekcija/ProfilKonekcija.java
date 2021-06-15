package com.nistagram.authenticationmicroservice.connection;
import com.nistagram.autentikacija.dto.ProfilDto;
import com.nistagram.autentikacija.dto.ProfilRegistrovaniDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "autentikacija", url = "http://localhost:7877/" )
public interface ProfilKonekcija {
        @PostMapping("/user/find")
        ProfilDto getUserByEmail(@RequestBody String email);

        @PostMapping("/user/add")
        void register(@RequestBody ProfilRegistrovaniDto userReg);


        }