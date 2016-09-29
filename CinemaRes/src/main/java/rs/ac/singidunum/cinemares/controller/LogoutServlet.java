package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        Kada korisnik zeli da se izloguje potrebno je da unistimo/invalidiramo njegovu sesiju.
        Tom prilikom i svi atributi sesije ce biti unisteni, izmedju ostalog i atribut "korisnik" 
        bez koga nije moguce pristupiti stranicama web aplikacije bez ponovne autentikacije.
        */
        request.getSession().invalidate();
        
        //Redirekcija na pocetnu stranicu
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
