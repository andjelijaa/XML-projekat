package com.example.Profilmicroservis.Repository;


import com.example.Profilmicroservis.Entitiy.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

    List<Profil> findAll();

    List<Profil> pretraga(String username);

    Profil save(Profil profil);

    Profil findByUsername(String username);

    Profil findByEmail(String email);

}
