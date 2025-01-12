package pt.iade.ei.ShareBill.models.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.ei.ShareBill.models.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    // Buscar uma pessoa pelo e-mail
    Optional<User> findByEmail(String email);
    List<User> findByNomeContainingIgnoreCase(String nome);
}




