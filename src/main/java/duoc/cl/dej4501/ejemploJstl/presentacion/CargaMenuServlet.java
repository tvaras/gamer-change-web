/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.presentacion;

import duoc.cl.dej4501.ejemploJstl.entidades.Usuario;
import duoc.cl.dej4501.ejemploJstl.negocio.MenuController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CargaMenuServlet", urlPatterns = {"/cargaMenuServlet", "/menu"})
public class CargaMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MenuController objMenuNegocio= new MenuController();
        Usuario objUsuarioConectado = (Usuario) request.getSession().getAttribute("usuarioConectado");        
        List listadoMenu = objMenuNegocio.cargarMenuPorPerfil(objUsuarioConectado.getCodigo_perfil());
        request.setAttribute("listaMenu", listadoMenu);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
