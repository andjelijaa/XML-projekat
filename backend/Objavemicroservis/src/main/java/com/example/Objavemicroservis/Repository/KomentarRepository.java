package com.example.Objavemicroservis.Repository;


import com.example.Objavemicroservis.Entity.Komentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {

    Komentar save(Komentar komentar);

    List<Komentar> findAll();
}
