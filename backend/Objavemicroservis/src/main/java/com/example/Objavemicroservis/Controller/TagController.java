package com.example.Objavemicroservis.Controller;

import com.example.Objavemicroservis.Entity.Hashtag;
import com.example.Objavemicroservis.Service.interfejs.IHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Hashtag create(@RequestBody Hashtag tag) {

        return tagService.create(tag);
    }
}