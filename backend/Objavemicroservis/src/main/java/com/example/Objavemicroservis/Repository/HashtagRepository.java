package com.example.Objavemicroservis.Repository;


import com.example.Objavemicroservis.Entity.Hashtag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    Hashtag sacuvaj(Hashtag hashtag);

    List<Hashtag> pronadjiSve();

    Hashtag pronadjiPoImenu(String naziv_hashtaga);
}
