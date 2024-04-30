package portfolio.miticode_backend.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portfolio.miticode_backend.exceptions.ModelAlreadyExistsException;
import portfolio.miticode_backend.models.Estudiante;
import portfolio.miticode_backend.repositories.IEstudianteRepo;
import portfolio.miticode_backend.services.IEstudianteService;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl extends CrudImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo estudianteRepo;

    @Override
    protected IEstudianteRepo getRepo() {
        return estudianteRepo;
    }

    @Override
    public void validateDniExistence(String dni) {
        getRepo().findEstudianteByDni(dni).ifPresent(estudiante -> {
            throw new ModelAlreadyExistsException("Estudiante con este DNI ya existe.");
        });
    }
}
