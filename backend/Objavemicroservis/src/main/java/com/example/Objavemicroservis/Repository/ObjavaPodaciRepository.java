package com.example.Objavemicroservis.Repository;

import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Repository
public interface ObjavaPodaciRepository extends JpaRepository<ObjavaPodaci, Long> {

    ObjavaPodaci save(ObjavaPodaci objavaPodaci);

    List<ObjavaPodaci> findAll();

    //List<ObjavaPodaci> findByUsername(String username);


   // List<ObjavaPodaci> (String lokacija);
}
