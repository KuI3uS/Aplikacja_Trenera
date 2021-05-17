package pl.jakubmarcinkowski.projekt.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/trenerzy")
public class TrenerServlet extends HttpServlet {

    @Inject
    private TrenerService trenerService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "trenerzy.ftlh");
        List<Trener> trenerzy = trenerService.getAll();
        model.put("trenerzy", trenerzy);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String imie = req.getParameter ( "imie" );
        String nazwisko = req.getParameter ( "nazwisko" );
        String email = req.getParameter ( "email" );
        String telefon = req.getParameter ( "telefon" );

        Trener trener = new Trener (imie, nazwisko, email, telefon);

        trenerService.add (trener);

        doGet (req,resp );
    }
}
