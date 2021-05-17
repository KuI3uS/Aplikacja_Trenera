package pl.jakubmarcinkowski.projekt.dao;

import pl.jakubmarcinkowski.projekt.domain.Trener;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Dao<E> {

    void add(E e);

    void update(E e);

    E findById(long id);

    void deleteById(long id);

    List<Trener> findAll();

}