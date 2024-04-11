package shaks.trimer.Agence.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ObjectService<T> {
    T save(T t);
    T findById(Integer id);
    List<T> findAll();
    T update(T t, Integer id);
    void delete(Integer id);

}
