/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.negocio;

import duoc.cl.dej4501.ejemploJstl.persistencia.MenuDAO;
import duoc.cl.dej4501.ejemploJstl.entidades.Menu;
import java.util.List;

public class MenuController {
    private MenuDAO objMenuDAO;

    public MenuController() {
        this.objMenuDAO= new MenuDAO();
    }
    
    public List<Menu> cargarMenuPorPerfil(int codigo_perfil){
        return this.objMenuDAO.listadoMenuPorPerfil(codigo_perfil);
    }
}
