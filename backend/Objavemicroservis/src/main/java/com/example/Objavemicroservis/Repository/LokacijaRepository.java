package com.example.Objavemicroservis.Repository;


import com.example.Objavemicroservis.Entity.Lokacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {
    Lokacija sacuvaj(Lokacija lokacija);
    List<Lokacija> pronadjiSve();
    Lokacija pronadji_po_imenu(String naziv_mesta);
    Lokacija pronadji_po_ID(Long id);
}
