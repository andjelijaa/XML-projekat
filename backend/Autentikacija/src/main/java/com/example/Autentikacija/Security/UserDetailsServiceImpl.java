package com.example.Autentikacija.Security;

import com.example.Autentikacija.Exception.NotFoundException;
import com.example.Autentikacija.Service.ProfilRegostrovani1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ProfilRegostrovani1Service profilRegostrovani1Service;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails profil = profilRegostrovani1Service.findByUsername(username);
        if (profil == null) {
            throw new NotFoundException("Username nije pronadjen");
        }
        return profil;
    }

}
