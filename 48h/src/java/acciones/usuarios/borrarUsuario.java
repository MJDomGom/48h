/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuarios;

import com.opensymphony.xwork2.ActionSupport;
import dao.usuarioDAO;
import java.util.List;
import pojos.Usuario;

/**
 *
 * @author mjdom
 */
public class borrarUsuario extends ActionSupport {

    private String oculto;
    private List<Usuario> listaUsuarios;

    public borrarUsuario() {
    }

    public String execute() throws Exception {
        new usuarioDAO().deleteUsuario(this.getOculto());
        listaUsuarios = new usuarioDAO().listarUsuarios();
        return SUCCESS;
    }

    public String getOculto() {
        return oculto;
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
