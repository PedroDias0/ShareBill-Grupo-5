package pt.iade.ei.ShareBill.models.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.ei.ShareBill.models.Categorias;


@Repository
public interface CategoriasRepository extends CrudRepository<Categorias, Integer> {

}




