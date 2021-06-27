package com.example.Objavemicroservis.Controller;

import com.example.Objavemicroservis.Entity.Lokacija;
import com.example.Objavemicroservis.Service.interfejs.ILokacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/lokacija")
public class LokacijaController {
    @Autowired
    private ILokacijaService lokacijaService;

    @GetMapping
    public List<Lokacija> getAll() {
        return lokacijaService.getAll();
    }

    @PostMapping
    public Lokacija create(@RequestBody Lokacija lokacija) {
        return lokacijaService.create(lokacija);
    }
}
