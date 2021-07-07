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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/slika")

public class ObjavaPodaciController {

    @Autowired
    private ObjavaPodaciRepository objavaPodaciRepository;

    @Autowired
    private ObjavaPodaciService objavaPodaciService;

    private static String upload = "profil-slike";

    @PostMapping("/sacuvaj")
    public List<String> sacuvajSliku(@RequestParam("file") List<MultipartFile> multipartFiles) throws IOException {
        List<String> fileNazivi=new ArrayList<>();
        for(MultipartFile multi: multipartFiles) {
            String fileNaziv = StringUtils.cleanPath(multi.getOriginalFilename().replaceAll("\\s", ""));
            upload = "profil-slike";
            FileUpload.sacuvajFile(upload, fileNaziv, multi);
            fileNazivi.add(fileNaziv);
        }
        return fileNazivi;
    }


    @GetMapping("/profil/{username}")
    public ResponseEntity getSlikeByUsername(@PathVariable("username") String username) {
        List<ObjavaPodaci> userObjavePodaci = objavaPodaciRepository.findObjavaPodaciByUsername(username);
        return new ResponseEntity(objavaPodaciService.getSlikeFiles(userObjavePodaci), HttpStatus.OK);
    }

    @PostMapping("/info")
    public ObjavaPodaci sacuvajSLikuInfo(@RequestBody ObjavaDTO objavaDTO) {
        return objavaPodaciService.sacuvajSlikaInfo(objavaDTO);
    }

    @GetMapping("/nadjene/{username}")
    public ResponseEntity getNadjeneSlike(@PathVariable("username") String username) {
        List<ObjavaPodaci> nadjeno = objavaPodaciService.getJavneObjave();

    //  dodati
        return new ResponseEntity(objavaPodaciService.getSlikeFiles(nadjeno), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSlikaById(@PathVariable("id") Long id) {
        return new ResponseEntity(objavaPodaciService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/pretragatag")
    public ResponseEntity pretragaTag(@RequestParam String tag) {
        List<ObjavaPodaci> userObjavePodaci = objavaPodaciRepository.findObjavaPodaciByHashtagovi(tag);
        return new ResponseEntity(objavaPodaciService.getSlikeFiles(userObjavePodaci), HttpStatus.OK);
        //return new ResponseEntity(objavaPodaciService.pretraziTag(tag), HttpStatus.OK);
    }

    @GetMapping("/pretragalokacija")
    public ResponseEntity pretragaLokacija(@RequestParam String lokacija) {
        List<ObjavaPodaci> userObjavePodaci = objavaPodaciRepository.findObjavaPodaciByLokacija(lokacija);
        return new ResponseEntity(objavaPodaciService.getSlikeFiles(userObjavePodaci), HttpStatus.OK);
        //return new ResponseEntity(objavaPodaciService.pretraziLokaciju(lokacija), HttpStatus.OK);
    }


}