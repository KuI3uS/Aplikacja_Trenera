package pl.jakubmarcinkowski.projekt.servlet;

import jdk.jfr.Event;
import pl.jakubmarcinkowski.projekt.dao.Dao;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EventService {

    @EJB(name = "events")
    Dao dao;

    public List<Event> findAll() {
        List list = dao.findAll ();

        return list;
    }

    public void add(Event event) {
        dao.add ( event );
    }

    public void deleteById(long id) {
        dao.deleteById ( id );
    }

    public void update(Event event) {
        dao.update ( event );
    }

    public Event findById(long id) {
        return ( Event ) dao.findById ( id );
    }
}
