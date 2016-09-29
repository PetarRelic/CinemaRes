package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.singidunum.cinemares.data.Bioskop;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;
import rs.ac.singidunum.cinemares.service.BioskopService;


public class BioskopServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, CinemaResException {
        
        String action = request.getParameter("action");
        TipAkcije tipAkcije = TipAkcije.getForAction(action);

        try {
            switch (tipAkcije) {
                case ADD: {
                    String naziv = request.getParameter("naziv");
                    String adresa = request.getParameter("adresa");

                    Bioskop bioskop = new Bioskop(naziv, adresa);

                    BioskopService.getInstance().add(bioskop);

                    request.setAttribute("message", "Bioskop " + bioskop.getNaziv()+ " uspesno dodat.");
                    break;
                }
                case EDIT: {
                    String naziv = request.getParameter("naziv");
                    String adresa = request.getParameter("adresa");
                    Integer idBioskop = Integer.parseInt(request.getParameter("idBioskop"));

                    Bioskop bioskop = new Bioskop(idBioskop, naziv, adresa);

                    BioskopService.getInstance().edit(bioskop);

                    request.setAttribute("message", "Bioskop " + bioskop.getNaziv() + " uspesno izmenjen.");
                    break;
                }
                case DELETE: {
                    Integer idBioskop = Integer.parseInt(request.getParameter("idBioskop"));
                    Bioskop bioskop = new Bioskop(idBioskop);
                    BioskopService.getInstance().delete(bioskop);
                    
                    request.setAttribute("message", "Bioskop je uspesno izbrisan.");
                    break;
                }
            }
        } catch (CinemaResException ex) {
            request.setAttribute("errors", ex.getErrorMessages());
        }

        List<Bioskop> bioskopi = BioskopService.getInstance().findAll();
       
        /*
        Listu sa svim bioskopima stavljamo u atribut "bioskopi" u request scope.
        Na JSP stranici iteriramo kroz ovu listu i u tabeli prikazujemo bioskope.
        */
        request.setAttribute("bioskopi", bioskopi);
        
        //treba napraviti da se izbacuje na section bioskopi
        request.getRequestDispatcher("/WEB-INF/pages/bioskopi.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (CinemaResException ex) {
            Logger.getLogger(BioskopServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (CinemaResException ex) {
            Logger.getLogger(BioskopServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
