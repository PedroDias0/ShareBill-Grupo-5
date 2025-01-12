package pt.iade.ei.ShareBill.models.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.ei.ShareBill.models.Despesas;


@Repository
public interface DespesasRepository extends CrudRepository<Despesas, Integer> {

}




