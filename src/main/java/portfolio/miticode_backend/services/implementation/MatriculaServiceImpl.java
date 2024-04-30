package portfolio.miticode_backend.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portfolio.miticode_backend.models.Matricula;
import portfolio.miticode_backend.repositories.IGenericRepo;
import portfolio.miticode_backend.repositories.IMatriculaRepo;
import portfolio.miticode_backend.services.IMatriculaService;

@RequiredArgsConstructor
@Service
public class MatriculaServiceImpl extends CrudImpl<Matricula, Integer> implements IMatriculaService {
    private final IMatriculaRepo matriculaRepo;
    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return matriculaRepo;
    }
}
