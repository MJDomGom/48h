/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.usuarioDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.Usuario;

/**
 *
 * @author mjdom
 */
public class cargarUsuarios extends ActionSupport {
    List<Usuario> listaUsuarios = new ArrayList();
    
    public cargarUsuarios() {
    }
    
    public String execute() throws Exception {
        listaUsuarios = new usuarioDAO().listarUsuarios();
        return SUCCESS;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}