package com.example.Profilmicroservis.Repository;


import com.example.Profilmicroservis.Entitiy.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

    List<Profil> findAll();

    Profil save(Profil profil);

    Profil findByUsername(String username);

    Profil findByEmail(String email);

    @Query(value = "select u from Profil u where lower(u.username) like concat('%', lower(:username), '%' ) " +
            "and u.javniprofil = true")
    List<Profil> search(String username);

}
