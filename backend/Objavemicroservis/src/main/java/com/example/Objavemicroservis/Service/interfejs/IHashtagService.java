package com.example.Objavemicroservis.service.interfejs;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateLikeDto;
import com.mediamicroservice.mediamicroservice.domain.Like;

import java.util.List;

public interface IHashtagService {

    List<Hashtag> getAll();

    Hashtag kreiraj(Hashtag hashtag);

    List<Hashtag> kreirajHasTag(List<String> tagovi);
}

