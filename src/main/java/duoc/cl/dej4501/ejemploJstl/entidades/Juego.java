package duoc.cl.dej4501.ejemploJstl.entidades;

import java.util.Date;

/**
 * @author tvaras
 * 2019-04-11
 */
public class Juego {

	private Long id;
	private Date fechaCreacion;
	private String nombre;
	private Consola consola = new Consola();
	private TiempoUso tiempoUso = new TiempoUso();
	private EstadoJuego estadoJuego = new EstadoJuego();
	private String comentario;
	private Boolean intercambiado;
	private Date fechaIntercambio;
	private Usuario dueno;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Consola getConsola() {
		return consola;
	}

	public void setConsola(Consola consola) {
		this.consola = consola;
	}

	public TiempoUso getTiempoUso() {
		return tiempoUso;
	}

	public void setTiempoUso(TiempoUso tiempoUso) {
		this.tiempoUso = tiempoUso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public EstadoJuego getEstadoJuego() {
		return estadoJuego;
	}

	public void setEstadoJuego(EstadoJuego estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIntercambiado() {
		return intercambiado;
	}

	public void setIntercambiado(Boolean intercambiado) {
		this.intercambiado = intercambiado;
	}

	public Usuario getDueno() {
		return dueno;
	}

	public void setDueno(Usuario dueno) {
		this.dueno = dueno;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaIntercambio() {
		return fechaIntercambio;
	}

	public void setFechaIntercambio(Date fechaIntercambio) {
		this.fechaIntercambio = fechaIntercambio;
	}
	
}
