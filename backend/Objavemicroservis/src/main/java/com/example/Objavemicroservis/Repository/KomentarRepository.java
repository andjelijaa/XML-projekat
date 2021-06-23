package com.example.Objavemicroservis.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {

    Komentar sacuvaj(Komentar komentar);

    List<Komentar> pronadjiSve();
}
