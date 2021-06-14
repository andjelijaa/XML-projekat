package com.example.Autentikacija.Entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name="Uloge")
public class Uloga implements GrantedAuthority {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "uloge")
    private Collection<ProfilRegistrovani> profil;

    @Override
    public String getAuthority() {
        return name;
    }
}
