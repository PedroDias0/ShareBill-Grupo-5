package pt.iade.ei.ShareBill.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pt.iade.ei.ShareBill.models.Amigos;

import java.util.List;
import java.util.Optional;

public interface AmigosRepository extends CrudRepository<Amigos, Integer> {
    Optional<Amigos> findByUtilizador1IdAndUtilizador2Id(int utilizador1Id, int utilizador2Id);

    // Consulta para buscar todas as amizades envolvendo um usuário específico
    @Query("SELECT a FROM Amigos a WHERE a.utilizador1.id = :userId OR a.utilizador2.id = :userId")
    Iterable<Amigos> findAllByUserId(int userId);

    @Query("SELECT a FROM Amigos a WHERE (a.utilizador1.id = :userId OR a.utilizador2.id = :userId) AND a.estado = :estado")
    List<Amigos> findAmigosByUserIdAndEstado(@Param("userId") int userId, @Param("estado") Amigos.Estado estado);

    List<Amigos> findByEstado(String estado);
}
