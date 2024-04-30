package portfolio.miticode_backend.services;

import portfolio.miticode_backend.models.Estudiante;

public interface IEstudianteService extends ICrud<Estudiante, Integer> {
    void validateDniExistence(String dni);
}
