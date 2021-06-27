package com.example.Objavemicroservis.Service;


import com.example.Objavemicroservis.Entity.Hashtag;
import com.example.Objavemicroservis.Repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Objavemicroservis.Service.interfejs.IHashtagService;

import java.util.ArrayList;
import java.util.List;


@Service
public class HashtagService implements IHashtagService {


    private HashtagRepository tagRepository;

    @Override
    public List<Hashtag> getAll() {
        List<Hashtag> tagovi = tagRepository.findAll();

            return tagovi;
    }

    @Override
    public Hashtag create(Hashtag tag) {
        return tagRepository.save(tag);
    }


    @Override
    public List<Hashtag> kreirajHashTag(List<String> tags) {
        List<Hashtag> tagDb = new ArrayList<>();
      //  for (String t : tags) {
            //if (tagRepository.findByName(t) == null) {
           //     Hashtag tag = new Hashtag();
       //         tag.setNaziv_hashtaga(t.toLowerCase());
    //            kreiraj(tag);
   //             tagDb.add(tag);
     //       }
   //     }
        return tagDb;
    }

}