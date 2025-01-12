package pt.iade.ei.ShareBill.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.ei.ShareBill.models.Amigos;
import pt.iade.ei.ShareBill.models.User;
import pt.iade.ei.ShareBill.models.repositories.AmigosRepository;
import pt.iade.ei.ShareBill.models.repositories.UserRepository;
import pt.iade.ei.ShareBill.service.AmigosService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/amigos")
public class AmigosController {
    private final Logger logger = LoggerFactory.getLogger(AmigosController.class);

    @Autowired
    private AmigosRepository amigosRepository;

    @Autowired
    private UserRepository userRepository;  // Adicionando o repositório de usuários para facilitar a criação da amizade

    @Autowired
    private AmigosService amigosService;

    // Endpoint para buscar todos os registros de amigos
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Amigos> getAmigos() {
        logger.info("Fetching all accepted friendships");
        // Filtro para buscar apenas as amizades com o estado "Accepted"
        return amigosRepository.findByEstado("Accepted");
    }

    // Endpoint para buscar todos os amigos de um usuário específico
    @GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAmigosByUserId(@PathVariable int userId) {
        logger.info("Fetching all friends of user with id {}", userId);

        // Buscar todas as amizades envolvendo o usuário especificado
        Iterable<Amigos> amizades = amigosRepository.findAllByUserId(userId);

        // Extrair os amigos (podem ser utilizador1 ou utilizador2)
        List<User> amigos = new ArrayList<>();
        for (Amigos amizade : amizades) {
            if (amizade.getUtilizador1().getId() == userId) {
                amigos.add(amizade.getUtilizador2());
            } else if (amizade.getUtilizador2().getId() == userId) {
                amigos.add(amizade.getUtilizador1());
            }
        }
        return amigos;
    }

    @GetMapping(path = "/user/{userId}/pending", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Amigos> getPendingAmigosByUserId(@PathVariable int userId) {
        logger.info("Fetching all pending friendships for user with id {}", userId);
        return amigosRepository.findAmigosByUserIdAndEstado(userId, Amigos.Estado.Pending);
    }


    // Endpoint para buscar um registro específico por ID
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Amigos> getAmigo(@PathVariable int id) {
        logger.info("Fetching friendship record with id {}", id);
        return amigosRepository.findById(id);
    }

    // Endpoint para criar um novo registro de amizade
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Amigos addAmigo(@RequestBody Amigos amigo) {
        logger.info("Adding new friendship record between user {} and user {}",
                amigo.getUtilizador1().getId(), amigo.getUtilizador2().getId());

        // Garantir que os usuários estão corretamente associados à amizade
        User utilizador1 = userRepository.findById(amigo.getUtilizador1().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User 1 not found"));

        User utilizador2 = userRepository.findById(amigo.getUtilizador2().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User 2 not found"));

        // Configurar o estado da amizade como "Pending"
        amigo.setEstado(Amigos.Estado.Pending);
        amigo.setUtilizador1(utilizador1);
        amigo.setUtilizador2(utilizador2);
        amigo.setDataPedido(java.time.LocalDateTime.now());

        // Salvar a amizade
        return amigosRepository.save(amigo);
    }

    // Endpoint para deletar um registro de amizade pelo ID
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAmigo(@PathVariable int id) {
        logger.info("Deleting friendship record with id {}", id);
        if (amigosRepository.existsById(id)) {
            amigosRepository.deleteById(id);
            return "Friendship record with id " + id + " deleted successfully.";
        } else {
            return "Friendship record with id " + id + " not found.";
        }
    }

    @PatchMapping(path = "/{utilizador1Id}/accept/{utilizador2Id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Amigos acceptFriendRequest(@PathVariable int utilizador1Id, @PathVariable int utilizador2Id) {
        logger.info("User {} attempting to accept friendship request from user {}", utilizador2Id, utilizador1Id);

        // Chamar o serviço que já tem a lógica de aceitação
        return amigosService.acceptFriendRequest(utilizador1Id, utilizador2Id);
    }

}
