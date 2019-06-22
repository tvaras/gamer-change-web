/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.entidades;

import java.io.Serializable;

/**
 *
 * @author amontess
 */
public class Perfil implements Serializable {

    private int codigo_perfil;
    private String nombre_perfil;

    public Perfil() {
    }

    public Perfil(int codigo_perfil, String nombre_perfil) {
        this.codigo_perfil = codigo_perfil;
        this.nombre_perfil = nombre_perfil;
    }

    public int getCodigo_perfil() {
        return codigo_perfil;
    }

    public void setCodigo_perfil(int codigo_perfil) {
        this.codigo_perfil = codigo_perfil;
    }

    public String getNombre_perfil() {
        return nombre_perfil;
    }

    public void setNombre_perfil(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }

    @Override
    public String toString() {
        return "Perfil{" + "codigo_perfil=" + codigo_perfil + ", nombre_perfil=" + nombre_perfil + '}';
    }

}
