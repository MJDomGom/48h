/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuarios;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.usuarioDAO;
import java.util.Map;
import pojos.Usuario;

/**
 *
 * @author mjdom
 */
public class updateRedirect extends ActionSupport {

    private String oculto;
    private Usuario upd;
    private Map session;

    public updateRedirect() {
    }

    public String execute() throws Exception {
        //Se cargan los datos necesarios del usuario para preparar un update de su información
        upd = new usuarioDAO().getUsuario(oculto);
        session = (Map) ActionContext.getContext().getSession();
        session.put("NickUpd", upd.getNick());
        session.put("NombreUpd", upd.getNombre());
        session.put("PassUpd", upd.getPassword());
        session.put("RolUpd", upd.getRol());
        return SUCCESS;
    }

    public String getOculto() {
        return oculto;
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }

    public Usuario getUpd() {
        return upd;
    }

    public void setUpd(Usuario upd) {
        this.upd = upd;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

}
