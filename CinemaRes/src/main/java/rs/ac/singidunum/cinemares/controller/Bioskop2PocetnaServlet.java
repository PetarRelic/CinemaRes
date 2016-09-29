package rs.ac.singidunum.cinemares.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.singidunum.cinemares.data.Bioskop;
import rs.ac.singidunum.cinemares.service.BioskopService;

public class Bioskop2PocetnaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Bioskop> bioskopi = BioskopService.getInstance().findAll();
       
        
        request.setAttribute("bioskopi", bioskopi);
        
        request.getRequestDispatcher("/WEB-INF/pages/bioskopi.jsp").forward(request, response);    
        
        
        }
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
