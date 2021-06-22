package com.example.Profilmicroservis;

import com.example.Profilmicroservis.Entitiy.DTO.ProfilDTO;
import com.example.Profilmicroservis.Entitiy.DTO.ProfilRegistrovaniDTO;
import com.example.Profilmicroservis.Entitiy.Profil;

import java.util.ArrayList;
import java.util.List;

public class ProfilMapper {


    public static ProfilDTO mapProfilToProfilDto(Profil profil) {
        ProfilDTO profilDto = new ProfilDTO();
        profilDto.setUsername(profil.getUsername());
        profilDto.setIme(profil.getIme());
        profilDto.setPrezime(profil.getPrezime());
        profilDto.setEmail(profil.getEmail());
        profilDto.setTelefon(profil.getTelefon());
        profilDto.setWebSite(profil.getWebSite());
        profilDto.setBiografija(profil.getBiografija());
        profilDto.setDatumrodjenja(profil.getDatumRodjenja());
        profilDto.setPol(profil.getPol());
        return profilDto;
    }

    public static Profil mapProfilDtoToProfil(ProfilDTO profilDto) {
        Profil profil = new Profil();
        profil.setIme(profilDto.getIme());
        profil.setPrezime(profilDto.getPrezime());
        profil.setEmail(profilDto.getEmail());
        profil.setTelefon(profilDto.getTelefon());
        profil.setPol(profilDto.getPol());
        profil.setDatumRodjenja(profilDto.getDatumrodjenja());
        profil.setUsername(profilDto.getUsername());
        profil.setWebSite(profilDto.getWebSite());
        profil.setBiografija(profilDto.getBiografija());
        return profil;
    }


    public static List<ProfilDTO> mapProfilListToProfilDTOList(List<Profil> profili) {
        List<ProfilDTO> profilDTOS = new ArrayList<>();
        for (Profil u : profili)
            profilDTOS.add(mapProfilToProfilDto(u));
        return profilDTOS;
    }



    public static Profil mapProfilRegistrovaniDtoToProfil(ProfilRegistrovaniDTO registrovaniDTO){
        Profil profil = new Profil();
        profil.setUsername(registrovaniDTO.getUsername());
        profil.setIme(registrovaniDTO.getIme());
        profil.setPrezime(registrovaniDTO.getPrezime());
        profil.setEmail(registrovaniDTO.getEmail());
        return profil;
    }




}
