package com.example.Objavemicroservis.Repository;

import com.mediamicroservice.mediamicroservice.controller.dto.CreateCommentDto;
import com.mediamicroservice.mediamicroservice.domain.Comment;
import com.mediamicroservice.mediamicroservice.logger.Logger;
import com.mediamicroservice.mediamicroservice.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {

    Komentar sacuvaj(Komentar komentar);

    List<Komentar> pronadjiSve();
}
