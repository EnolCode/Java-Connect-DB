package api.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import api.models.Employed;
import api.payloads.EmployedPayload;
import api.views.view;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/api/employed")

public class EmployedController extends HttpServlet { // Con este objeto tenemos acceso a muchos metodos para tratar las Api
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // Esta clase nos devuelve la respuesta, la peticion y si no nos devueleve un error

        resp.setContentType("application/json;charset=UTF-8"); // Tenemos que definir que tipo sera la respuesta que vamos a recibir.
        
        PrintWriter out = resp.getWriter(); // El objeto que devolveremos en la salida.

        Employed employed = new Employed();
        List<EmployedPayload> employeds =  employed.index(); // Pasamos a la vista la lista de nuestros empleados en payloads


        out.println(view.show(employeds));

    }
    
}
