package com.example.Objavemicroservis.Repository;

import com.example.Objavemicroservis.Entity.ObjavaPodaci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ObjavaPodaciRepository extends JpaRepository<ObjavaPodaci, Long> {

    ObjavaPodaci save(ObjavaPodaci objavaPodaci);

    List<ObjavaPodaci> findAll();

    List<ObjavaPodaci> findObjavaPodaciByUsername(String username);

    ObjavaPodaci findObjavaPodaciById(Long id);


    List<ObjavaPodaci> findObjavaPodaciByLokacija(String lokacija);


    List<ObjavaPodaci> findObjavaPodaciByHashtagovi(String hashtagovi);

   // @Query(value = "select p from ObjavaPodaci p where lower(p.objavapodaci.lokacija.name) like concat('%', lower(:lokacija), '%' )")
    //List<ObjavaPodaci> searchLokacija(String lokacija);

}
