package com.example.Objavemicroservis.Controller;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateCommentDto;
import com.mediamicroservice.mediamicroservice.domain.Comment;
import com.mediamicroservice.mediamicroservice.logger.Logger;
import com.mediamicroservice.mediamicroservice.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private IHashtagService tagService;

    @GetMapping
    public List<Hashtag> getAll() {
        return tagService.getAll();
    }

    @PostMapping
    public Hashtag kreiraj(@RequestBody Hashtag tag) {
        return tagService.kreiraj(tag);
    }
}