/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.ejemploJstl.negocio;

import duoc.cl.dej4501.ejemploJstl.persistencia.PerfilDAO;
import duoc.cl.dej4501.ejemploJstl.entidades.Perfil;
import java.util.List;

public class PerfilController {
    PerfilDAO objPerfilDAO;

    public PerfilController() {
        this.objPerfilDAO= new PerfilDAO();
    }
    
    public List<Perfil> getAllPerfil(){
        return this.objPerfilDAO.readElementos();
    }
    
    public Perfil getPerfilXCodigo(int codigoPerfil){
        return this.objPerfilDAO.buscaPerfilPOrID(codigoPerfil);
    }
    
    public boolean addPerfil(Perfil perfil){
        return this.objPerfilDAO.addElemento(perfil);
    }
}
