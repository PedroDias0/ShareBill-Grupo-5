package pt.iade.ei.ShareBill.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.ei.ShareBill.models.Grupo;
import pt.iade.ei.ShareBill.models.Ug;
import pt.iade.ei.ShareBill.models.User;
import pt.iade.ei.ShareBill.models.repositories.GrupoRepository;
import pt.iade.ei.ShareBill.models.repositories.UgRepository;
import pt.iade.ei.ShareBill.models.repositories.UserRepository;

@RestController
@RequestMapping(path = "/api/grupos")
public class UgController {
    private final Logger logger = LoggerFactory.getLogger(GrupoController.class);

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private UgRepository ugRepository;

    @Autowired
    private UserRepository userRepository;

    // Criar um novo grupo
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Grupo createGrupo(@RequestBody Grupo grupo) {
        logger.info("Creating a new group with name {}", grupo.getNome());
        return grupoRepository.save(grupo);
    }

    // Adicionar um usuário a um grupo
    @PostMapping(path = "/{grupoId}/add-user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ug addUserToGrupo(@PathVariable int grupoId, @PathVariable int userId) {
        logger.info("Adding user {} to group {}", userId, grupoId);

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (ugRepository.existsByUserAndGrupo(user, grupo)) {
            logger.warn("User {} is already in group {}", userId, grupoId);
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User is already in this group");
        }

        Ug ug = new Ug();
        ug.setUser(user);
        ug.setGrupo(grupo);
        return ugRepository.save(ug);
    }

    // Remover um usuário de um grupo
    @DeleteMapping(path = "/{grupoId}/remove-user/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUserFromGrupo(@PathVariable int grupoId, @PathVariable int userId) {
        logger.info("Removing user {} from group {}", userId, grupoId);

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Ug ug = ugRepository.findByUserAndGrupo(user, grupo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User is not part of this group"));

        ugRepository.delete(ug);
        logger.info("User {} removed from group {}", userId, grupoId);
    }

    // Deletar um grupo
    @DeleteMapping(path = "/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGrupo(@PathVariable int grupoId) {
        logger.info("Deleting group with id {}", grupoId);

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found"));

        // Remover todas as associações UG relacionadas ao grupo
        ugRepository.deleteAllByGrupo(grupo);

        // Deletar o grupo
        grupoRepository.delete(grupo);
        logger.info("Group with id {} deleted", grupoId);
    }

    // Listar todos os usuários em um grupo
    @GetMapping(path = "/{grupoId}/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getUsersInGrupo(@PathVariable int grupoId) {
        logger.info("Fetching all users in group {}", grupoId);

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found"));

        return ugRepository.findAllByGrupo(grupo)
                .stream()
                .map(Ug::getUser) // Mapeia de Ug para User
                .toList();
    }

    // Listar todos os grupos de um usuário
    @GetMapping(path = "/user/{userId}/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Grupo> getGroupsForUser(@PathVariable int userId) {
        logger.info("Fetching all groups for user {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return ugRepository.findAllByUser(user)
                .stream()
                .map(Ug::getGrupo) // Mapeia de Ug para Grupo
                .toList();
    }


}
