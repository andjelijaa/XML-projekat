package com.example.Objavemicroservis.Repository;


import com.example.Objavemicroservis.Entity.Objava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@Repository
public interface ObjavaRepository extends JpaRepository<Objava, Long> {



}
