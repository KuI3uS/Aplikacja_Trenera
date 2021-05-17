package main.java.pl.jakubmarcinkowski.projekt.servlet;

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

@WebServlet("/trenerzy/usun")
public class TrenerUsunServlet extends HttpServlet {

    @Inject
    private TrenerService trenerService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter ( "id" ));
        trenerService.deleteById ( id );

        resp.sendRedirect ( "/projekt/trenerzy" );
    }
}
