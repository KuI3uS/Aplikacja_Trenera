package main.java.pl.jakubmarcinkowski.projekt.dao;

import pl.jakubmarcinkowski.projekt.domain.Trener;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Stateless(name="trenerzy")
public class TrenerDao implements Dao<Trener> {

    @PersistenceContext(unitName = "trenerzy-db")
    protected EntityManager entityManager;

    @Override
    @Transactional
    public void add(Trener trener) {
        entityManager.persist ( trener );
    }

    @Override
    public void update(Trener trener) {
        entityManager.merge(trener);
    }

    @Override
    public Trener findById(long id) {
        return entityManager.find ( Trener.class, id );
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Trener trener = findById (id);
        entityManager.remove(trener);
    }

    @Override
    @Transactional
    public List<Trener> findAll() {
        TypedQuery<Trener> query = entityManager.createQuery ( "FROM Trener", Trener.class );
        List<Trener> treners = query.getResultList ();
        return treners;
    }

}

