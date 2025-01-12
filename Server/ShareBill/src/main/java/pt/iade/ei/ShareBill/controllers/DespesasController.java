package pt.iade.ei.ShareBill.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.ei.ShareBill.models.Despesas;
import pt.iade.ei.ShareBill.models.repositories.DespesasRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/despesas")
public class DespesasController {
    private final Logger logger = LoggerFactory.getLogger(DespesasController.class);
    @Autowired
    private DespesasRepository despesasRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Despesas> getDespesas() {
        logger.info("Sending all users without sensitive data");
        return despesasRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Despesas> getDespesa(@PathVariable int id) {
        logger.info("Sending user with id {} without sensitive data", id);
        return despesasRepository.findById(id);
    }
}
