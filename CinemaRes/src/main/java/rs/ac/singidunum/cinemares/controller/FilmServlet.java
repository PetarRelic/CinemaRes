package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.singidunum.cinemares.data.Film;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;
import rs.ac.singidunum.cinemares.service.FilmService;


public class FilmServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action"); 
        TipAkcije tipAkcije = TipAkcije.getForAction(action);
       

        try {
            switch (tipAkcije) {
                case ADD: {
                    String naziv = request.getParameter("naziv");
                    String zanr = request.getParameter("zanr");

                    Film film = new Film(naziv, zanr);

                    FilmService.getInstance().add(film);

                    request.setAttribute("message", "Film " + film.getNaziv()+ " uspesno dodata.");
                    break;
                }
                case EDIT: {
                    String naziv = request.getParameter("naziv");
                    String zanr = request.getParameter("zanr");
                    Integer idFilm = Integer.parseInt(request.getParameter("idFilm"));

                    Film film = new Film(idFilm, naziv, zanr);

                    FilmService.getInstance().edit(film);

                    request.setAttribute("message", "Film " + film.getNaziv() + " uspesno izmenjena.");
                    break;
                }
                case DELETE: {
                    Integer idFilm = Integer.parseInt(request.getParameter("idFilm"));
                    Film film = new Film(idFilm);
                    FilmService.getInstance().delete(film);
                    
                    request.setAttribute("message", "Film je uspesno izbrisan.");
                    break;
                }
            }
        } catch (CinemaResException ex) {
            request.setAttribute("errors", ex.getErrorMessages());
        }

        List<Film> filmovi = FilmService.getInstance().findAll();
       
        
        
        /*
        Listu sa svim filmovima stavljamo u atribut "filmovi" u request scope.
        Na JSP strnici iteriramo kroz ovu listu i u tabeli prikazujemo filmove.
        */
        request.setAttribute("filmovi", filmovi);
        
        //treba napraviti da se izbacuje na section filmovi
        request.getRequestDispatcher("/WEB-INF/pages/filmovi.jsp").forward(request, response);
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
