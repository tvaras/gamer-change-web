/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.presentacion;

import duoc.cl.dej4501.ejemploJstl.entidades.Perfil;
import duoc.cl.dej4501.ejemploJstl.negocio.PerfilController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "GetAllPerfilesservlet", urlPatterns = {"/getAllPerfilesservlet","/listadoPerfil"})
public class GetAllPerfilesservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PerfilController objPerfilNegocio= new PerfilController();
        List<Perfil>listadoPerfil=objPerfilNegocio.getAllPerfil();
        HttpSession sesion= request.getSession();
        sesion.setAttribute("listaPerfil", listadoPerfil);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
}
