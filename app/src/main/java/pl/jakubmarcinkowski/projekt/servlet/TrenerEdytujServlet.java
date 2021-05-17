package main.java.pl.jakubmarcinkowski.projekt.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.jakubmarcinkowski.projekt.client.Event;
import pl.jakubmarcinkowski.projekt.client.EventType;
import pl.jakubmarcinkowski.projekt.client.TrackingClient;
import pl.jakubmarcinkowski.projekt.domain.Trener;
import pl.jakubmarcinkowski.projekt.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/trenerzy/edytuj")
public class TrenerEdytujServlet extends HttpServlet {

    @Inject
    private TrenerService trenerService;

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "edytujTrenera.ftlh");

        long id = Long.parseLong(req.getParameter ( "id" ));
        Trener trener = trenerService.findById ( id );
        model.put("trener", trener);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter ( "id" ));
        String imie = req.getParameter ( "imie" );
        String nazwisko = req.getParameter ( "nazwisko" );
        String email = req.getParameter ( "email" );
        String telefon = req.getParameter ( "telefon" );

        Trener trener = new Trener (id, imie, nazwisko, email, telefon);

        trenerService.update (trener);
        TrackingClient.addEvent (new Event ( Inet4Address.getLocalHost().getHostAddress(), EventType.EDYCJA_TRENERA , "http://localhost:8080/trenerzy/edytuj/"+id, LocalDateTime.now ().toString () ) );
        resp.sendRedirect ( "/projekt/trenerzy" );
    }
}
