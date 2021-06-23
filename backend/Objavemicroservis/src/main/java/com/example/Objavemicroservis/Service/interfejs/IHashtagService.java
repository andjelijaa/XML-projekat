package com.example.Objavemicroservis.service.interfejs;


import java.util.List;

public interface IHashtagService {

    List<Hashtag> getAll();

    Hashtag kreiraj(Hashtag hashtag);

    List<Hashtag> kreirajHasTag(List<String> tagovi);
}

