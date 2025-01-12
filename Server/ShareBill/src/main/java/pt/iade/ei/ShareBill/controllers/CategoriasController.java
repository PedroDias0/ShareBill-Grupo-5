package pt.iade.ei.ShareBill.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.ei.ShareBill.models.Categorias;
import pt.iade.ei.ShareBill.models.repositories.CategoriasRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/categorias")
public class CategoriasController {
    private final Logger logger = LoggerFactory.getLogger(CategoriasController.class);
    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Categorias> getCategorias() {
        logger.info("Sending all users without sensitive data");
        return categoriasRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Categorias> getCategoria(@PathVariable int id) {
        logger.info("Sending user with id {} without sensitive data", id);
        return categoriasRepository.findById(id);
    }
}









