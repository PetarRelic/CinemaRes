package rs.ac.singidunum.cinemares.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AccessFilter {
    
    
    private static final List<String> NO_AUTH_URLs = Arrays.asList("/index.jsp");

    public AccessFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        //Dohvatanje URL-a kome korisnik pokusava da pristupi.
        String url = httpRequest.getServletPath();

        //Ako dobijeni URL nije u listi onih za koje nije potrebna autentikacija potrebno je proveriti da li je korisnik ulogovan.
        if (!NO_AUTH_URLs.contains(url)) {
            /*
            Provera da li je korisnik ulogovan se vrsi tako sto se proveri da li u sesiji ima atribut pod nazivom "korisnik".
            Ovaj atribut dodajemo u sesiju u LoginServlet-u kada korisnik prodje autentikacijsku proceduru.
            Atribut se brise iz sesijeu LogoutServlet-u, odnosno kada korisnik klikne na link za odjavu sa aplikacije.
            */
            if (httpRequest.getSession().getAttribute("korisnik") == null) { 
                /*
                U korisnikovoj sesiji nije pronadjen atribut "korisnik" --> korisnik nije ulogovan.
                U zahtev, HTTP REQUEST, u attribut "errors" smestamo niz sa jednom greskom koja informise korisnika da se prijavi.
                Korisnika redirektujemo na stranicu index.jsp.
                */
                httpRequest.setAttribute("errors", new String[]{"Morate se prijaviti na sistem."});
                httpRequest.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

        chain.doFilter(request, response);

    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
    
}
