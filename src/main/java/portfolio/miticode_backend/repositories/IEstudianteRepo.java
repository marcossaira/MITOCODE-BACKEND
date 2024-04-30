package portfolio.miticode_backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import portfolio.miticode_backend.models.Estudiante;

import java.util.Optional;

@Repository
public interface IEstudianteRepo extends IGenericRepo<Estudiante, Integer> {

    Optional<Estudiante> findEstudianteByDni(String dni);
}
