package duoc.cl.dej4501.ejemploJstl.negocio;

import java.util.List;

import duoc.cl.dej4501.ejemploJstl.entidades.Consola;
import duoc.cl.dej4501.ejemploJstl.entidades.EstadoJuego;
import duoc.cl.dej4501.ejemploJstl.entidades.Juego;
import duoc.cl.dej4501.ejemploJstl.entidades.TiempoUso;
import duoc.cl.dej4501.ejemploJstl.entidades.Usuario;
import duoc.cl.dej4501.ejemploJstl.persistencia.EntidadSimpleDAO;
import duoc.cl.dej4501.ejemploJstl.persistencia.JuegoDAO;

/**
 * @author tvaras
 * 2019-04-11
 */
public class JuegoController {

	private EntidadSimpleDAO entidadSimpleDAO;
	private JuegoDAO juegoDAO;

	public JuegoController() {
		
		this.entidadSimpleDAO = new EntidadSimpleDAO();
		this.juegoDAO = new JuegoDAO();
	}
	
	public List<EstadoJuego> listaEstadoJuego() {
		
		return this.entidadSimpleDAO.listaEstadoJuego();
	}
	
	public List<TiempoUso> listaTiempoUso() {
		
		return this.entidadSimpleDAO.listaTiempoUso();
	}
	
	public List<Consola> listaConsola() {
		
		return this.entidadSimpleDAO.listaConsola();
	}
	
	public boolean registrarJuego(Juego nuevoJuego) {
		
		return this.juegoDAO.addElemento(nuevoJuego);
	}
	
	public List<Juego> listaJuegosPorUsuario(Usuario usuario) {
		
		return this.juegoDAO.listaJuegosPorUsuario(usuario);
	}
}
