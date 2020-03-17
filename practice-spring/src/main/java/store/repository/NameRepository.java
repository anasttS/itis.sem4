package store.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import store.model.Name;


@Repository
public interface NameRepository extends CrudRepository<Name, Long> {
}