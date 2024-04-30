package portfolio.miticode_backend.services;

import java.util.List;

public interface ICrud<T, ID> {
    T save(T t);
    T findById(ID id);
    T getReferenceById(ID id);
    void deleteById(ID id);
    List<T> findAll();
}
