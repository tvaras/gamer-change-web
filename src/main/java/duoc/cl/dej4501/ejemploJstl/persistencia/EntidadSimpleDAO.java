package duoc.cl.dej4501.ejemploJstl.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import duoc.cl.dej4501.ejemploJstl.entidades.Consola;
import duoc.cl.dej4501.ejemploJstl.entidades.EstadoJuego;
import duoc.cl.dej4501.ejemploJstl.entidades.TiempoUso;

/**
 * @author tvaras
 * 2019-04-11
 */
public class EntidadSimpleDAO {
	
    public List<Consola> listaConsola(){
    	List<Consola> lista = new ArrayList<Consola>();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM consola ORDER BY id_consola";
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	Consola entidad = new Consola(rs.getInt(1), rs.getString(2));
            	lista.add(entidad);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información: "+e.getMessage());
        }
        return lista;
    }
	
    public List<TiempoUso> listaTiempoUso(){
    	List<TiempoUso> lista = new ArrayList<TiempoUso>();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM tiempo_uso ORDER BY id_tiempo_uso";
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	TiempoUso entidad = new TiempoUso(rs.getInt(1), rs.getString(2));
            	lista.add(entidad);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información: "+e.getMessage());
        }
        return lista;
    }
	
    public List<EstadoJuego> listaEstadoJuego(){
    	List<EstadoJuego> lista = new ArrayList<EstadoJuego>();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM estado_juego ORDER BY id_estado_juego";
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	EstadoJuego entidad = new EstadoJuego(rs.getInt(1), rs.getString(2));
            	lista.add(entidad);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información: "+e.getMessage());
        }
        return lista;
    }
}
