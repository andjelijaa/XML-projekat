package com.example.Objavemicroservis.Controller;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateCommentDto;
import com.mediamicroservice.mediamicroservice.domain.Comment;
import com.mediamicroservice.mediamicroservice.logger.Logger;
import com.mediamicroservice.mediamicroservice.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/komentar")
public class KomentarController{

    @Autowired
    private IKomentarService komentarService;

    @PostMapping
    public Komentar kreirajKomentar(@RequestBody KomentarDTO komentarDTO) {
        return KomentarService.kreirajKomentar(komentarDTO);
    }
}
