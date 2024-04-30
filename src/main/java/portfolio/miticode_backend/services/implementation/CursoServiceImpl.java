package portfolio.miticode_backend.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portfolio.miticode_backend.exceptions.CursoAlreadyExistsException;
import portfolio.miticode_backend.exceptions.ModelAlreadyExistsException;
import portfolio.miticode_backend.models.Curso;
import portfolio.miticode_backend.repositories.ICursoRepo;
import portfolio.miticode_backend.services.ICursoService;

@RequiredArgsConstructor
@Service
public class CursoServiceImpl extends CrudImpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo cursoRepo;

    @Override
    protected ICursoRepo getRepo() {
        return cursoRepo;
    }

    @Override
    public void validateNameExistence(String name) {
        getRepo().findCursoByNombre(name).ifPresent(curso -> {
            throw new ModelAlreadyExistsException("Curso con este nombre ya existe.");
        });
    }
}
