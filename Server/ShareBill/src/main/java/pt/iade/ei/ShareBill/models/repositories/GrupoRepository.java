package pt.iade.ei.ShareBill.models.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.ei.ShareBill.models.Grupo;


@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Integer> {

}
