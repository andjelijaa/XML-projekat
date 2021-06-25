package com.example.Objavemicroservis.Repository;


import com.example.Objavemicroservis.Entity.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {
    Lokacija save(Lokacija lokacija);
    List<Lokacija> findAll();
    Lokacija findByName(String name);
}
