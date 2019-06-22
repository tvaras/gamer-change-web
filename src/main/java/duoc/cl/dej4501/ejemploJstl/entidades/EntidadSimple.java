package duoc.cl.dej4501.ejemploJstl.entidades;

/**
 * @author tvaras
 * 2019-04-11
 */
public abstract class EntidadSimple {

	private Integer id;
	private String descripcion;
	
	public EntidadSimple() { }
	
	public EntidadSimple(Integer id) {
		this.id = id;
	}
	
	public EntidadSimple(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
