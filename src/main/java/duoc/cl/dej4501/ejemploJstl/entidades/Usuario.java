/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.entidades;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{
    private int codigo_usuario;
    private String login_usuario;
    private String pass_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String correo_usuario;
    private int edad_usuario;
    private int codigo_perfil;
    private Date fechaNacimiento_perfil;

    public Usuario() {
    }

    public Usuario(int codigo_usuario) {
    	this.codigo_usuario = codigo_usuario;
    }

    public Usuario(int codigo_usuario, String login_usuario, String pass_usuario, String nombre_usuario, String apellido_usuario, String correo_usuario, int edad_usuario, int codigo_perfil, Date fechaNacimiento_perfil) {
        this.codigo_usuario = codigo_usuario;
        this.login_usuario = login_usuario;
        this.pass_usuario = pass_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.correo_usuario = correo_usuario;
        this.edad_usuario = edad_usuario;
        this.codigo_perfil = codigo_perfil;
        this.fechaNacimiento_perfil = fechaNacimiento_perfil;
    }
    
    public Date getFechaNacimiento_perfil() {
        return fechaNacimiento_perfil;
    }

    public void setFechaNacimiento_perfil(Date fechaNacimiento_perfil) {
        this.fechaNacimiento_perfil = fechaNacimiento_perfil;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public int getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(int edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public int getCodigo_perfil() {
        return codigo_perfil;
    }

    public void setCodigo_perfil(int codigo_perfil) {
        this.codigo_perfil = codigo_perfil;
    }

  

    @Override
    public String toString() {
        return "Usuarios{" + "codigo_usuario=" + codigo_usuario + ", login_usuario=" + login_usuario + ", pass_usuario=" + pass_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", correo_usuario=" + correo_usuario + ", edad_usuario=" + edad_usuario + ", codigo_perfil=" + codigo_perfil + ", fechaNacimiento_perfil=" + fechaNacimiento_perfil + '}';
    }
}
