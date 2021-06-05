/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuarios;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.usuarioDAO;
import java.util.List;
import java.util.Map;
import pojos.Usuario;

/**
 *
 * @author mjdom
 */
public class registrarUsuario extends ActionSupport {

    private String nick;
    private String nombre;
    private String password;
    private Map session;
    private List<Usuario> listaUsuarios;

    public registrarUsuario() {
    }

    public String execute() throws Exception {
        if (this.getNick() == null || this.getNombre() == null || this.getPassword() == null) {
            return ERROR;
        }
        new usuarioDAO().registrarUsuario(this.nick, this.nombre, this.password);
        session = (Map) ActionContext.getContext().getSession();
        session.put("nick", this.getNick());
        session.put("password", this.getPassword());
        session.put("rol", "Cliente");
        listaUsuarios = new usuarioDAO().listarUsuarios();
        return SUCCESS;
    }

    public String getNick() {
        return nick;
    }

    @RequiredStringValidator(message = "Debe rellenar el campo 'nick'")
    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    @RequiredStringValidator(message = "Debe rellenar el campo 'nombre'")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Debe rellenar el campo 'contraseña'")
    public void setPassword(String password) {
        this.password = password;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
