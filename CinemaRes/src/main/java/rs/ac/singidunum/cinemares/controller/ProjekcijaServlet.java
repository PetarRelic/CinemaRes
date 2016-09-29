package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.singidunum.cinemares.data.Film;
import rs.ac.singidunum.cinemares.data.Projekcija;
import rs.ac.singidunum.cinemares.data.Sala;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;
import rs.ac.singidunum.cinemares.service.ProjekcijaService;

public class ProjekcijaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        TipAkcije tipAkcije = TipAkcije.getForAction(action);

        try {
            switch (tipAkcije) {
                case ADD: {
                    
                    String termin_projekcije = request.getParameter("termin_projekcije");
                    
                    Integer fk_Film=Integer.parseInt(request.getParameter("fk_Film"));
                    Integer fk_Sala=Integer.parseInt(request.getParameter("fk_Sala"));
                    Film film=new Film(fk_Film);
                    Sala sala=new Sala(fk_Sala);
                    
                    Projekcija projekcija = new Projekcija(termin_projekcije,film,sala);

                    ProjekcijaService.getInstance().add(projekcija);

                    request.setAttribute("message", "Projekcija " + projekcija.getTermin_projekcije()+ " uspesno dodata.");
                    break;
                }
                case DELETE: {
                    Integer idProjekcije = Integer.parseInt(request.getParameter("idProjekcije"));
                    Integer fk_Film = Integer.parseInt(request.getParameter("fk_Film"));
                    Integer fk_Sala = Integer.parseInt(request.getParameter("fk_Sala"));
                    Film film = new Film(fk_Film);
                    Sala sala = new Sala(fk_Sala);
                    
                    Projekcija projekcija = new Projekcija(idProjekcije,film,sala);
                    
                    ProjekcijaService.getInstance().delete(projekcija);
                    
                    
                    request.setAttribute("message", "Projekcija je uspesno izbrisana.");
                    break;
                }
            }
        } catch (CinemaResException ex) {
            request.setAttribute("errors", ex.getErrorMessages());
        }

        List<Projekcija> projekcije = ProjekcijaService.getInstance().findAll();
       
        /*
        Listu sa svim projekcijama stavljamo u atribut "projekcije" u request scope.
        Na JSP strnici iteriramo kroz ovu listu i u tabeli prikazujemo projekcije.
        */
        request.setAttribute("projekcije", projekcije);
        
        //treba napraviti da se izbacuje na section projekcije
        request.getRequestDispatcher("/WEB-INF/pages/projekcije.jsp").forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
}
