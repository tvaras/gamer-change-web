/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.persistencia;

import duoc.cl.dej4501.ejemploJstl.entidades.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MenuDAO {
    
    public MenuDAO() {
    }
  
    public List listadoMenuPorPerfil(int perfil){
        List listadoMenu= new LinkedList();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM menu WHERE perfil_codigo=? ORDER BY padre_menu";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, perfil);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Menu objMenu= new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
                listadoMenu.add(objMenu);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información"+e.getMessage());
        }
        return listadoMenu;
    }
}
