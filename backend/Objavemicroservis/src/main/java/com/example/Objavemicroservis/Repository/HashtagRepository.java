package com.example.Objavemicroservis.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    Hashtag sacuvaj(Hashtag hashtag);

    List<Hashtag> pronadjiSve();

    Hashtag pronadjiPoImenu(String naziv_hashtaga);
}
