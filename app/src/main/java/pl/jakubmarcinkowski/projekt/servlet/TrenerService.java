package pl.jakubmarcinkowski.projekt.servlet;

import pl.jakubmarcinkowski.projekt.dao.Dao;
import pl.jakubmarcinkowski.projekt.dao.TrenerDao;
import pl.jakubmarcinkowski.projekt.domain.Trener;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class TrenerService {

    @EJB(name = "trenerzy")
    Dao dao;

    public List<Trener> getAll() {
        List list = dao.findAll ();

        return list;
    }

    public void add(Trener trener) {
        dao.add ( trener );
    }

    public void deleteById(long id) {
        dao.deleteById ( id );
    }

    public void update(Trener trener){
        dao.update ( trener );
    }

    public Trener findById(long id) {
        return ( Trener ) dao.findById ( id );
    }
}
