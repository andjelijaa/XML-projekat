package com.example.Objavemicroservis.service.interfejs;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateLikeDto;
import com.mediamicroservice.mediamicroservice.domain.Like;

import java.util.List;

public interface IObjavaPodaciService {

    List<ObjavaPodaci> getAll();

    ObjavaPodaci sacuvaj(ObjavaPodaci objavaPodaci);

    List<ObjavaPodaci> getKorisnikSlike(String username);

    ObjavaPodaci sacuvajSlikaInfo(ObjavaDTO slikaDto);

   // List<ImageBytesDto> getImagesFiles(List<Post> posts);

   // ImageBytesDto getImageFile(Post post);

   // ImageBytesDto imageFile(Post post, String filePath);

    ObjavaPodaci getById(Long id);

    //ImageBytesDto getImageFileById(Long id);

    //List<ImageBytesDto> searchTag(String tag);

   // List<ImageBytesDto> searchLocation(String location);

    List<ObjavaPodaci> getJavneObjave();
}
