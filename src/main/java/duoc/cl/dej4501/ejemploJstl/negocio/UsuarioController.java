/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.negocio;

import duoc.cl.dej4501.ejemploJstl.entidades.Usuario;
import duoc.cl.dej4501.ejemploJstl.persistencia.UsuarioDAO;

public class UsuarioController {
    private UsuarioDAO objUsuarioDAO;

    public UsuarioController() {
        this.objUsuarioDAO= new UsuarioDAO();
    }
    
    public Usuario compruebaUsuario(String login,String pass){
        return this.objUsuarioDAO.compruebaUsuario(login, pass);
    }
}
