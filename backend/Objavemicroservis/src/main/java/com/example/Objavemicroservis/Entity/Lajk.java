package com.example.Objavemicroservis.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "lajkovi")
@Data
public class Lajk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean lajkovano = true;

}
