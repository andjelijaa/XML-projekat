package com.example.Objavemicroservis.Controller;

import com.example.Objavemicroservis.DTO.LajkDTO;
import com.example.Objavemicroservis.Entity.Lajk;
import com.example.Objavemicroservis.Service.interfejs.ILajkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/like")
public class LajkController {

    @Autowired
    private ILajkService lajkService;

    @PostMapping
    public Lajk kreirajLajk(@RequestBody LajkDTO lajkDTO) {
        return lajkService.kreirajLajk(lajkDTO);
    }



// mozes da vidis sta ovde ide umesto getimagesbyusername
    @GetMapping("/{id}")
    public Integer getImagesByUsername(@PathVariable("id") Long id) {
        return lajkService.prebrojLajkove(id);
    }

    @GetMapping("/post/{id}/{username}")
    public boolean da_li_je_lajkovano(@PathVariable("id") Long id, @PathVariable("username") String username) {
        return lajkService.da_li_je_lajkovano(id, username);
    }

    @GetMapping("/istorija/{username}")
    public List<Lajk> istorija(@PathVariable("username")String username){
        return lajkService.istorija(username);
    }
}