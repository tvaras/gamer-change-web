package duoc.cl.dej4501.ejemploJstl.presentacion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duoc.cl.dej4501.ejemploJstl.entidades.Juego;
import duoc.cl.dej4501.ejemploJstl.entidades.Usuario;
import duoc.cl.dej4501.ejemploJstl.negocio.JuegoController;

/**
 * @author tvaras 2019-04-11
 */
@WebServlet(name = "JuegoServlet", urlPatterns = "/ingresar-juego.html")
public class JuegoServlet extends HttpServlet {

	private static final long serialVersionUID = -2982119549243854934L;
	
	private JuegoController controller = new JuegoController();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuarioConectado = (Usuario) session.getAttribute("usuarioConectado");
        
        if(usuarioConectado != null) {

    		Juego juegoNuevo = new Juego();
    		
    		juegoNuevo.setDueno(usuarioConectado);
    		juegoNuevo.setNombre(request.getParameter("juego.nombre"));
    		juegoNuevo.setComentario(request.getParameter("juego.comentario"));
    		juegoNuevo.getConsola().setId(Integer.parseInt(request.getParameter("juego.consola.id")));
    		juegoNuevo.getTiempoUso().setId(Integer.parseInt(request.getParameter("juego.tiempoUso.id")));
    		juegoNuevo.getEstadoJuego().setId(Integer.parseInt(request.getParameter("juego.estadoJuego.id")));
    		
    	    request.setAttribute("listaConsola", controller.listaConsola());
    	    request.setAttribute("listaTiempoUso", controller.listaTiempoUso());
    	    request.setAttribute("listaEstadoJuego", controller.listaEstadoJuego());
		    request.setAttribute("listaJuego", controller.listaJuegosPorUsuario(usuarioConectado));
    			
    		boolean resultado = controller.registrarJuego(juegoNuevo);
    		
    		if(resultado) {
    			request.setAttribute("mensaje", "Juego registrado correctamente!");
    			request.setAttribute("mensajeStatus", "success");
    		} else {
    			request.setAttribute("mensaje", "No fue posible registrar Juego!");
    			request.setAttribute("mensajeStatus", "danger");
    		}
    		
    	    request.setAttribute("juego", juegoNuevo);
    	    
    	    request.getRequestDispatcher("FormularioJuego.jsp").forward(request, response);
		
        } else {
        	response.sendRedirect("Login.jsp");
        }
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        HttpSession session = request.getSession();
        
        Usuario usuarioConectado = (Usuario) session.getAttribute("usuarioConectado");
        
        if(usuarioConectado != null) {
			
			Juego juego = new Juego();
			juego.setDueno(usuarioConectado);
			
		    request.setAttribute("listaConsola", controller.listaConsola());
		    request.setAttribute("listaTiempoUso", controller.listaTiempoUso());
		    request.setAttribute("listaEstadoJuego", controller.listaEstadoJuego());
		    request.setAttribute("listaJuego", controller.listaJuegosPorUsuario(usuarioConectado));
		    request.setAttribute("juego", juego);
		    
		    request.getRequestDispatcher("FormularioJuego.jsp").forward(request, response);
		
        } else {
        	response.sendRedirect("Login.jsp");
        }
	}
}
