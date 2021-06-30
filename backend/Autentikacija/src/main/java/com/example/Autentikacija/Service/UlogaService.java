package com.example.Autentikacija.Service;

import com.example.Autentikacija.Entity.Uloga;
import com.example.Autentikacija.Repository.Uloga1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UlogaService implements  Uloga1Service {
    @Autowired
    private Uloga1Repository uloga1Repository;

    @Override
    public List<Uloga> findById(Long id) {
        //Uloga uloga = uloga1Repository.findById(id);
        List<Uloga> uloge = new ArrayList<>();
        //uloge.add(uloga);
        return uloge;
    }


    @Override
    public List<Uloga> findByName(String name) {

        Uloga uloga = uloga1Repository.findByName(name);
        List<Uloga> uloge = new ArrayList<>();
        uloge.add(uloga);
        return uloge;
    }
}
