package com.example.Objavemicroservis.Controller;


import com.example.Objavemicroservis.DTO.ObjavaDTO;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import com.example.Objavemicroservis.FileUpload;
import com.example.Objavemicroservis.Repository.ObjavaPodaciRepository;
import com.example.Objavemicroservis.Service.ObjavaPodaciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/slika")

public class ObjavaPodaciController {

    private ObjavaPodaciRepository objavaPodaciRepository;

    @Autowired
    private ObjavaPodaciService objavaPodaciService;

    private static String upload = "profil-slike";

    @PostMapping
    public String sacuvajSliku(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileNaziv = StringUtils.cleanPath(multipartFile.getOriginalFilename().replaceAll("\\s", ""));
        upload = "profil-slike";
        FileUpload.sacuvajFile(upload, fileNaziv, multipartFile);
        return fileNaziv;
    }


    @GetMapping("/profil/{username}")
    public ResponseEntity getImagesByUsername(@PathVariable("username") String username) {
    //TODO
    return null;
    }

    @PostMapping("/info")
    public ObjavaPodaci sacuvajSLikuInfo(@RequestBody ObjavaDTO objavaDTO) {
        return objavaPodaciService.sacuvajSlikaInfo(objavaDTO);
    }

    @GetMapping("/nadjene/{username}")
    public ResponseEntity getNadjeneSlike(@PathVariable("username") String username) {
        List<ObjavaPodaci> nadjeno = objavaPodaciService.getJavneObjave();

    //  dodati
       return  null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getSlikaById(@PathVariable("id") Long id) {
        return new ResponseEntity(objavaPodaciService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/pretragatag")
    public ResponseEntity pretragaTag(@RequestParam String tag) {
        return new ResponseEntity(objavaPodaciService.pretraziTag(tag), HttpStatus.OK);
    }

    @GetMapping("/pretragalokacija")
    public ResponseEntity pretragaLokacija(@RequestParam String lokacija) {
        return new ResponseEntity(objavaPodaciService.pretraziLokaciju(lokacija), HttpStatus.OK);
    }

    @GetMapping("/pretragausername")
    public ResponseEntity pretragaUsername(@RequestParam String username) {
        //return new ResponseEntity(objavaPodaciService.(username), HttpStatus.OK);
        return null;
    }
}