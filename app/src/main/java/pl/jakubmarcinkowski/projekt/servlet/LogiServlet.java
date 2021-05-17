package pl.jakubmarcinkowski.projekt.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.jakubmarcinkowski.projekt.client.Event;
import pl.jakubmarcinkowski.projekt.client.TrackingClient;
import pl.jakubmarcinkowski.projekt.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/logi")
public class LogiServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter ();

        Map<String, Object> model = new HashMap<> ();
        Template template = templateProvider.getTemplate ( getServletContext (), "logi.ftlh" );
        List<Event> logi = TrackingClient.getLogs ();
        System.out.println (logi);
        model.put ( "logi", logi );

        try {
            template.process ( model, writer );
        } catch (TemplateException e) {
            e.printStackTrace ();
        }
    }
}
