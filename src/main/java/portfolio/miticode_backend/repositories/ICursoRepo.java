package portfolio.miticode_backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import portfolio.miticode_backend.models.Curso;

import java.util.Optional;

@Repository
public interface ICursoRepo extends IGenericRepo<Curso, Integer>{

    @Query("SELECT c FROM Curso c WHERE LOWER(c.nombre) = LOWER(:nombre)")
    Optional<Curso> findCursoByNombre(String nombre);
}
