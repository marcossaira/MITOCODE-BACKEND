package portfolio.miticode_backend.services;

import portfolio.miticode_backend.models.Curso;

public interface ICursoService extends ICrud<Curso, Integer>{
    void validateNameExistence(String name);
}
