/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.usuarioDAO;
import java.util.List;
import pojos.Usuario;

/**
 *
 * @author mjdom
 */
public class updateUsuario extends ActionSupport {

    private List<Usuario> listaUsuarios;
    private String nombreUpd;
    private String passUpd;
    private String rolUpd;
    private String nickUpd;

    public updateUsuario() {
    }

    public String execute() throws Exception {
        Usuario upd = new Usuario(this.getNickUpd(), this.getNombreUpd(), this.getPassUpd(), this.getRolUpd());
        listaUsuarios = new usuarioDAO().updateUsuario(upd);
        return SUCCESS;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombreUpd() {
        return nombreUpd;
    }

    @RequiredStringValidator(message = "Debe de insertar un nombre de usuario")
    public void setNombreUpd(String nombreUpd) {
        this.nombreUpd = nombreUpd;
    }

    public String getPassUpd() {
        return passUpd;
    }

    @RequiredStringValidator(message = "Debe de insertar una contraseña")
    public void setPassUpd(String passUpd) {
        this.passUpd = passUpd;
    }

    public String getRolUpd() {
        return rolUpd;
    }

    public void setRolUpd(String rolUpd) {
        this.rolUpd = rolUpd;
    }

    public String getNickUpd() {
        return nickUpd;
    }

    @RequiredStringValidator(message = "Debe de insertar un nick")
    public void setNickUpd(String nickUpd) {
        this.nickUpd = nickUpd;
    }

}
