package com.example.Autentikacija.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Autentikacija.Entity.ProfilRegistrovani;

@Repository
public interface ProfilRegistrovaniRepository extends JpaRepository<ProfilRegistrovani, Long> {
       ProfilRegistrovani findByUsername(String username);
       ProfilRegistrovani save(ProfilRegistrovani profilRegistrovani);



}
