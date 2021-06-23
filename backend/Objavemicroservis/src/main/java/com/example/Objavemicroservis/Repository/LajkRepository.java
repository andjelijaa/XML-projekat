package com.example.Objavemicroservis.Repository;

import com.mediamicroservice.mediamicroservice.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LajkRepository extends JpaRepository<Lajk, Long> {
    Lajk sacuvah(Lajk lajk);
    List<Lajk> pronadjiSve();
    List<Lajk> pronadjiLajkPoUsername(String username);
}