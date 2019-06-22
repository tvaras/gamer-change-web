package duoc.cl.dej4501.ejemploJstl.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import duoc.cl.dej4501.ejemploJstl.entidades.Consola;
import duoc.cl.dej4501.ejemploJstl.entidades.EstadoJuego;
import duoc.cl.dej4501.ejemploJstl.entidades.Juego;
import duoc.cl.dej4501.ejemploJstl.entidades.TiempoUso;
import duoc.cl.dej4501.ejemploJstl.entidades.Usuario;

/**
 * @author tvaras
 * 2019-04-11
 */
public class JuegoDAO implements ICrud {

	public boolean addElemento(Object objetoInsert) {
		
		Juego entidad = (Juego) objetoInsert;
		
        try {
        	
            Connection con = Conexion.getConexion();
            
            String query = "INSERT INTO juego ( nombre, id_consola, " 
            + "id_tiempo_uso, id_estado_juego, comentario, " + 
            		"id_usuario) VALUES(?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, entidad.getNombre() );
            ps.setInt(2, entidad.getConsola().getId() );
            ps.setInt(3, entidad.getTiempoUso().getId() );
            ps.setInt(4, entidad.getEstadoJuego().getId() );
            ps.setString(5, entidad.getComentario() );
            ps.setInt(6, entidad.getDueno().getCodigo_usuario());
            
            return ps.executeUpdate() == 1;
                
        } catch (Exception e) {
            System.out.println("Error al Insertar en la BD" + e.getMessage());
            return false;
        }
	}

	public List readElementos() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateElemento(Object objetoUpdate) {
		
		Juego entidad = (Juego) objetoUpdate;
		
        try {
        	
            Connection con = Conexion.getConexion();
            
            String query = "update juego set dueno_id = ?, intercambiado = 1, fecha_intercambio = CURRENT_TIMESTAMP where id_juego = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, entidad.getDueno().getCodigo_usuario() );
            ps.setLong(2, entidad.getId() );
            
            return ps.executeUpdate() == 1;
                
        } catch (Exception e) {
            System.out.println("Error al Insertar en la BD" + e.getMessage());
            return false;
        }
	}

	public boolean deleteElemento(int idJuego) {
		
        try {
        	
            Connection con = Conexion.getConexion();
            
            String query = "delete from juego where id_juego = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idJuego );
            
            return ps.executeUpdate() == 1;
                
        } catch (Exception e) {
            System.out.println("Error al eliminar juego en la BD: " + e.getMessage());
            return false;
        }
	}

	public List<Juego> listaJuegosPorUsuario(Usuario usuario) {
		
    	List<Juego> lista = new ArrayList<Juego>();
    	
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT " + 
            		"j.id_juego, " + 
            		"j.fecha_creacion, " + 
            		"j.nombre, " + 
            		"j.id_consola, " + 
            		"j.id_tiempo_uso, " + 
            		"j.id_estado_juego, " + 
            		"j.comentario, " + 
            		"j.intercambiado, " + 
            		"j.fecha_intercambio, " + 
            		"j.id_usuario," + 
            		"c.descripcion," + 
            		"t.descripcion," + 
            		"e.descripcion " + 
            		"FROM juego j " + 
            		"inner join consola c on j.id_consola = c.id_consola " + 
            		"inner join tiempo_uso t on j.id_tiempo_uso = t.id_tiempo_uso " + 
            		"inner join estado_juego e on j.id_estado_juego = e.id_estado_juego " + 
            		"WHERE j.id_usuario=? ORDER BY fecha_creacion";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, usuario.getCodigo_usuario());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	
            	Juego e = new Juego();
            	
            	e.setId(rs.getLong(1));
            	e.setFechaCreacion(rs.getDate(2));
            	e.setNombre(rs.getString(3));
            	e.setConsola(new Consola(rs.getInt(4), rs.getString(11)));
            	e.setTiempoUso(new TiempoUso(rs.getInt(5), rs.getString(12)));
            	e.setEstadoJuego(new EstadoJuego(rs.getInt(6), rs.getString(13)));
            	e.setComentario(rs.getString(7));
            	e.setIntercambiado(rs.getBoolean(8));
            	e.setFechaIntercambio(rs.getDate(9));
            	e.setDueno(new Usuario(rs.getInt(10)));
            	
                lista.add(e);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información: "+e.getMessage());
        }
        return lista;
	}

}
