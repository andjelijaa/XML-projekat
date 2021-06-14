package com.example.Autentikacija.Repository;


import org.springframework.stereotype.Repository;
import com.example.Autentikacija.Entity.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Uloga1Repository extends JpaRepository<Uloga, Long> {
    Uloga findByName(String name);
}
