package com.example.Objavemicroservis.Service.interfejs;


import com.example.Objavemicroservis.Entity.Hashtag;

import java.util.List;

public interface IHashtagService {

    List<Hashtag> getAll();

    Hashtag kreiraj(Hashtag hashtag);

    List<Hashtag> kreirajHashTag(List<String> tagovi);
}

