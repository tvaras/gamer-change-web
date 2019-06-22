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
public class Menu implements Serializable{
    private int codigo_menu;
    private String nombre_menu;
    private int padre_menu;
    private String destino_menu;
    private int perfil_menu;

    public Menu() {
    }

    public Menu(int codigo_menu, String nombre_menu, int padre_menu, String destino_menu, int perfil_menu) {
        this.codigo_menu = codigo_menu;
        this.nombre_menu = nombre_menu;
        this.padre_menu = padre_menu;
        this.destino_menu = destino_menu;
        this.perfil_menu = perfil_menu;
    }

    public int getCodigo_menu() {
        return codigo_menu;
    }

    public void setCodigo_menu(int codigo_menu) {
        this.codigo_menu = codigo_menu;
    }

    public String getNombre_menu() {
        return nombre_menu;
    }

    public void setNombre_menu(String nombre_menu) {
        this.nombre_menu = nombre_menu;
    }

    public int getPadre_menu() {
        return padre_menu;
    }

    public void setPadre_menu(int padre_menu) {
        this.padre_menu = padre_menu;
    }

    public String getDestino_menu() {
        return destino_menu;
    }

    public void setDestino_menu(String destino_menu) {
        this.destino_menu = destino_menu;
    }

    public int getPerfil_menu() {
        return perfil_menu;
    }

    public void setPerfil_menu(int perfil_menu) {
        this.perfil_menu = perfil_menu;
    }

    @Override
    public String toString() {
        return "Menu{" + "codigo_menu=" + codigo_menu + ", nombre_menu=" + nombre_menu + ", padre_menu=" + padre_menu + ", destino_menu=" + destino_menu + ", perfil_menu=" + perfil_menu + '}';
    }
        
}
