package pt.iade.ei.ShareBill.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.ei.ShareBill.models.Ug;
import pt.iade.ei.ShareBill.models.User;
import pt.iade.ei.ShareBill.models.Grupo;

import java.util.List;
import java.util.Optional;

public interface UgRepository extends CrudRepository<Ug, Integer> {
    boolean existsByUserAndGrupo(User user, Grupo grupo);

    Optional<Ug> findByUserAndGrupo(User user, Grupo grupo);

    void deleteAllByGrupo(Grupo grupo);

    List<Ug> findAllByGrupo(Grupo grupo);

    List<Ug> findAllByUser(User user);
}
