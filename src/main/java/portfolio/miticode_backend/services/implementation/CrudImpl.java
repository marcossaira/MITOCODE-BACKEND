package portfolio.miticode_backend.services.implementation;

import portfolio.miticode_backend.exceptions.ModelNotFoundException;
import portfolio.miticode_backend.repositories.IGenericRepo;
import portfolio.miticode_backend.services.ICrud;

import java.util.List;
import java.util.Optional;

public abstract class CrudImpl<T, ID> implements ICrud<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(ModelNotFoundException::new);
    }

    @Override
    public T getReferenceById(ID id) {
        return Optional.of(getRepo().getReferenceById(id))
                .orElseThrow(ModelNotFoundException::new);
    }

    @Override
    public void deleteById(ID id) {
        getRepo().deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }
}
