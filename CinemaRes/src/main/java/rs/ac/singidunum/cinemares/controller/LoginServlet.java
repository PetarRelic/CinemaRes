package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.singidunum.cinemares.data.Korisnik;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;
import rs.ac.singidunum.cinemares.service.KorisnikService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Dohvatimo parametre forme, na osnovu njih kreiramo entity bean Korisnik
        String korisnicko_ime = request.getParameter("korisnicko_ime");
        String lozinka = request.getParameter("lozinka");
        
        Korisnik korisnik = new Korisnik(korisnicko_ime, lozinka);

        //Flag u kome cemo smestiti rezultat autentifikacije
        boolean authenticationSuccessful = false;

        try {
            authenticationSuccessful = KorisnikService.getInstance().checkLogin(korisnik);
        } catch (CinemaResException ex) {
            //Doslo je do greske, u request atribut "errors" cemo sacuvati listu gresaka
            request.setAttribute("errors", ex.getErrorMessages());
        }

        
        if (!authenticationSuccessful) {
            /*
            Autentikacija nije bila uspesna, u request atribut "errors" cemo dodati niz sa jednom porukom
            koja korisnika obavestava o neuspesnoj prijavi na sistem.
            */
            request.setAttribute("errors", new String[]{"Neuspešna prijava na sistem."});
        } else {
            /*
            Autentikacija je bila uspesna, u *sesiju* smestamo atribut "korisnik".
            Ovaj atribut koristimo u filter kada treba da proverimo da li je korisnik ulogovan ili nije.
            Ako u svojoj sesiji ima atribut "korisnik" korisni je ulogovan.
            */
            request.getSession().setAttribute("korisnik", korisnik);
        }

        //Koja je sledeca strana? /korisnik ako je autentikacija prosla, u protivnom vracamo na pocetnu stranicu
        String nextPage = (authenticationSuccessful) ? "korisnik" : "pocetna.jsp";

        request.getRequestDispatcher(nextPage).forward(request, response);
    }

   
    
   
}
