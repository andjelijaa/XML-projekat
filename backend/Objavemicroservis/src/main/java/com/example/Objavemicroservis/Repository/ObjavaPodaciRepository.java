package com.example.Objavemicroservis.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@Repository
public interface ObjavaPodaciRepository extends JpaRepository<ObjavaPodaci, Long> {
    ObjavaPodaci sacuvaj(ObjavaPodaci objavaPodaci);
    List<ObjavaPodaci> pronadjiSve();
    List<ObjavaPodaci> pronadjiPoObjavaUsername(String username);
    ObjavaPodaci pronadji_objavapodaci_po_ID(Long id);
    //

    List<ObjavaPodaci> pretraziLokaciju(String lokacija);
}
