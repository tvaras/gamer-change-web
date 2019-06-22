/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.persistencia;

import duoc.cl.dej4501.ejemploJstl.entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO implements ICrud{

    public UsuarioDAO() {
    }

    public boolean addElemento(Object objetoInsert) {
        Usuario objUsuario = (Usuario) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO usuario VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ultimoID());
            ps.setString(2, objUsuario.getLogin_usuario());
            ps.setString(3, objUsuario.getPass_usuario());
            ps.setString(4, objUsuario.getNombre_usuario());
            ps.setString(5, objUsuario.getApellido_usuario());
            ps.setString(6, objUsuario.getCorreo_usuario());
            ps.setInt(7, objUsuario.getEdad_usuario());
            ps.setInt(8, objUsuario.getCodigo_perfil());
            ps.setDate(9, new Date(objUsuario.getFechaNacimiento_perfil().getTime()));
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("error al insertar");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al Insertar en la BD" + e.getMessage());
        }
        return false;
    }

    public List readElementos() {
        List listadoUsuarios = new LinkedList();
        try {
            Connection con = Conexion.getConexion();
            String query = "select * from usuario";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario objUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9));
                listadoUsuarios.add(objUsuario);
            }
        } catch (Exception e) {
            System.out.println("error al conectar la BD" + e.getMessage());
        }
        return listadoUsuarios;
    }
    
    public boolean updateElemento(Object objetoUpdate) {
        Usuario objUsuario = (Usuario) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "update usuario set login_usuario=?,pass_usuario=?,nombre_usuario=?,apellido_usuario=?,correo_usuario=?,edad_usuario=?,codigo_perfil=?,fechaNacimiento_usuario=? where id_usuario=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin_usuario());
            ps.setString(2, objUsuario.getPass_usuario());
            ps.setString(3, objUsuario.getNombre_usuario());
            ps.setString(4, objUsuario.getApellido_usuario());
            ps.setString(5, objUsuario.getCorreo_usuario());
            ps.setInt(6, objUsuario.getEdad_usuario());
            ps.setInt(7, objUsuario.getCodigo_perfil());
            ps.setDate(8, new Date(objUsuario.getFechaNacimiento_perfil().getTime()));
            ps.setInt(9, objUsuario.getCodigo_usuario());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al updatear");
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos");
        }
        return false;
    }

    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM usuarios WHERE id_usuario=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al Eliminar el registros" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar los registros" + e.getMessage());
        }
        return false;
    }
    
    public int ultimoID() {
        int ultim = 0;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT MAX(id_usuario) FROM usuarios";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ultim = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la BD" + e.getMessage());
        }
        return ultim + 1;
    }

    public Usuario compruebaUsuario(String login, String pass) {
        Usuario ObjUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM usuario WHERE login_usuario= ? AND pass_usuario= ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ObjUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9));
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la BD" + e.getMessage());
        }

        return ObjUsuario;
    }

    public Usuario buscaUsuarioPorID(int codigo) {
        Usuario objUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "select * from usuario where id_usuario=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9));
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar la BD" + e);
        }
        return objUsuario;
    }
}
