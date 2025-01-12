package pt.iade.ei.ShareBill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.ei.ShareBill.models.Amigos;
import pt.iade.ei.ShareBill.models.User;
import pt.iade.ei.ShareBill.models.repositories.AmigosRepository;
import pt.iade.ei.ShareBill.models.repositories.UserRepository;

import java.util.Optional;

@Service
public class AmigosService {

    @Autowired
    private AmigosRepository amigosRepository;

    @Autowired
    private UserRepository userRepository;

    public Amigos acceptFriendRequest(int utilizador1Id, int utilizador2Id) {
        // Buscar a amizade entre os dois usuários
        Optional<Amigos> optionalAmigo = amigosRepository.findByUtilizador1IdAndUtilizador2Id(utilizador1Id, utilizador2Id);
        if (optionalAmigo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Friendship not found");
        }

        Amigos amigo = optionalAmigo.get();

        // Verificar se o utilizador2 é o responsável por aceitar a amizade
        if (amigo.getUtilizador2().getId() != utilizador2Id) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User not authorized to accept this friendship");
        }

        // Verificar se a amizade já foi aceita
        if (amigo.getEstado() == Amigos.Estado.Accepted) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Friendship already accepted");
        }

        // Atualizar o estado da amizade para "Accepted"
        amigo.setEstado(Amigos.Estado.Accepted);

        // Salvar a amizade atualizada no banco
        return amigosRepository.save(amigo);
    }
}
