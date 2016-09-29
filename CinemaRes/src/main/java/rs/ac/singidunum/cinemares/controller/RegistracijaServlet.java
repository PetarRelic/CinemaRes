package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.singidunum.cinemares.data.Korisnik;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;
import rs.ac.singidunum.cinemares.service.KorisnikService;

public class RegistracijaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TipAkcije tipAkcije = TipAkcije.getForAction("ADD");

        try {
            String korisnicko_ime = request.getParameter("korisnicko_ime");
            String email=request.getParameter("email");
            String lozinka = request.getParameter("lozinka");
           //Integer a = null;
            Korisnik korisnik = new Korisnik(korisnicko_ime, lozinka, email);

            KorisnikService.getInstance().add(korisnik);

            request.setAttribute("message", "Korisnik " + korisnik.getKorisnicko_ime()+ " uspesno dodat.");

        } catch (CinemaResException ex) {
            request.setAttribute("errors", ex.getErrorMessages());
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
