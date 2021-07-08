package com.example.Objavemicroservis.Controller;


import com.example.Objavemicroservis.DTO.KomentarDTO;
import com.example.Objavemicroservis.Entity.Komentar;
import com.example.Objavemicroservis.Service.interfejs.IKomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/komentar")
public class KomentarController{

    @Autowired
    private IKomentarService komentarService;

    @PostMapping("/kreiraj")
    public Komentar kreirajKomentar(@RequestBody KomentarDTO komentarDTO) {
        return komentarService.kreirajKomentar(komentarDTO);
    }
}
