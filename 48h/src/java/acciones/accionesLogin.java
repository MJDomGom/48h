/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.partidosDAO;
import dao.usuarioDAO;
import java.util.List;
import java.util.Map;
import pojos.Partidos;
import pojos.Usuario;

public class accionesLogin extends ActionSupport {

    private String nick;
    private String password;
    private Map session;
    private List<Partidos> listaPartidos;
    public accionesLogin() {
    }

    public String execute() throws Exception {
        Usuario user = new usuarioDAO().comprobarLogin(this.getNick(), this.getPassword());
        if (user != null) {
            session = (Map) ActionContext.getContext().getSession();
            session.put("nick", this.getNick());
            session.put("password", this.getPassword());
            session.put("rol", user.getRol());
            listaPartidos = new partidosDAO().listadoPartidos();
            return SUCCESS;
        } else {
            addFieldError("login", "El usuario o la contraseña no existen en el sistema");
            return ERROR;
        }
    }

    public String getNick() {
        return nick;
    }

    @RequiredStringValidator(message = "Debe especificar un nick")
    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Debe especificar una contraseña")
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Partidos> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partidos> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

}
