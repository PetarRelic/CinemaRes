package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.singidunum.cinemares.data.Bioskop;
import rs.ac.singidunum.cinemares.data.Sala;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;
import rs.ac.singidunum.cinemares.service.SalaService;

public class SalaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        TipAkcije tipAkcije = TipAkcije.getForAction(action);

        try {
            switch (tipAkcije) {
                case ADD: {
                    String br_sale = request.getParameter("br_sale");
                    String br_sedista = request.getParameter("br_sedista");
                    Integer fk_Bioskop=Integer.parseInt(request.getParameter("fk_Bioskop"));
                    Bioskop bioskop=new Bioskop(fk_Bioskop);

                    Sala sala = new Sala(br_sale, br_sedista,bioskop);

                    SalaService.getInstance().add(sala);

                    request.setAttribute("message", "Sala " + sala.getBr_sale()+ " uspesno dodata.");
                    break;
                }
                case EDIT: {
                    String br_sale = request.getParameter("br_sale");
                    String br_sedista = request.getParameter("br_sedista");
                    Integer idSala = Integer.parseInt(request.getParameter("idSala"));

                    Sala sala = new Sala(idSala, br_sale, br_sedista);

                    SalaService.getInstance().edit(sala);

                    request.setAttribute("message", "Sala " + sala.getBr_sale()+ " uspesno izmenjena.");
                    break;
                }
                case DELETE: {
                    Integer idSale = Integer.parseInt(request.getParameter("idSale")); 
                    Integer fk_Bioskop=Integer.parseInt(request.getParameter("fk_Bioskop"));
                    Bioskop bioskop=new Bioskop(fk_Bioskop);

                    Sala sala = new Sala(idSale,bioskop);
                    
                    SalaService.getInstance().delete(sala);
                    
                    request.setAttribute("message", "Sala je uspesno izbrisana.");
                    break;
                }
            }
        } catch (CinemaResException ex) {
            request.setAttribute("errors", ex.getErrorMessages());
        }

        List<Sala> sale = SalaService.getInstance().findAll();
       
        /*
        Listu sa svim salama stavljamo u atribut "sale" u request scope.
        Na JSP strnici iteriramo kroz ovu listu i u tabeli prikazujemo sale.
        */
        request.setAttribute("sale", sale);
        
        //treba napraviti da se izbacuje na section sale
        request.getRequestDispatcher("/WEB-INF/pages/sala.jsp").forward(request, response);
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
    
   
   

