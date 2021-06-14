package com.example.Autentikacija.Service;

import com.example.Autentikacija.Entity.Uloga;

import java.util.List;

public interface Uloga1Service {
    List<Uloga> findById(Long id);

    List<Uloga> findByName(String name);
}
