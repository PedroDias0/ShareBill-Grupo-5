package pt.iade.ei.ShareBill.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.ei.ShareBill.models.Grupo;
import pt.iade.ei.ShareBill.models.repositories.GrupoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/grupo")
public class GrupoController {
    private final Logger logger = LoggerFactory.getLogger(Grupo.class);
    @Autowired
    private GrupoRepository GrupoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Grupo> getGrupo() {
        logger.info("Sending all users without sensitive data");
        return GrupoRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Grupo> getGrupo(@PathVariable int id) {
        logger.info("Sending user with id {} without sensitive data", id);
        return GrupoRepository.findById(id);
    }
}
