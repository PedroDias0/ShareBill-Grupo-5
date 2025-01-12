package pt.iade.ei.ShareBill.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.ei.ShareBill.models.Atividades;
import pt.iade.ei.ShareBill.models.repositories.AtividadesRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/atividades")
public class AtividadesController {
    private final Logger logger = LoggerFactory.getLogger(AtividadesController.class);
    @Autowired
    private AtividadesRepository atividadesRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Atividades> getAtividades() {
        logger.info("Sending all users without sensitive data");
        return atividadesRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Atividades> getAtividade(@PathVariable int id) {
        logger.info("Sending user with id {} without sensitive data", id);
        return atividadesRepository.findById(id);
    }
}









