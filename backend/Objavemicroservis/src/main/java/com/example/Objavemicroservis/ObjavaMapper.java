package com.example.Objavemicroservis;

import com.example.Objavemicroservis.DTO.SlikaDTO;
import com.example.Objavemicroservis.Entity.ObjavaPodaci;

import java.util.ArrayList;

public class ObjavaMapper {


        public static SlikaDTO mapObjavaPodaciToSlikaDTO(ObjavaPodaci objavaPodaci) {
            SlikaDTO slikaDTO = new SlikaDTO();
            slikaDTO.setId(objavaPodaci.getId());
            slikaDTO.setUsername(objavaPodaci.getObjava().getUsername());
            slikaDTO.setOpis(objavaPodaci.getObjava().getOpis());
            slikaDTO.setLokacija(objavaPodaci.getObjava().getLokacija());
            slikaDTO.setHashtagovi(objavaPodaci.getObjava().getHashtagovi());
            slikaDTO.setKomentari(objavaPodaci.getKomentari());
            slikaDTO.setKodSlike(new ArrayList<>());
            slikaDTO.setLajkovi(objavaPodaci.getLajkovi());
            return slikaDTO;
        }

}
