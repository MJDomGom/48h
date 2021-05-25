/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author mjdom
 */
public class borrarInstalaciones extends ActionSupport {

    private Map session;
    private int oculto;

    public borrarInstalaciones() {
    }

    public String execute() throws Exception { new dao.instalacionesDAO().borrarInstalaciones(this.getOculto());
        return SUCCESS;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public int getOculto() {
        return oculto;
    }

    public void setOculto(int oculto) {
        this.oculto = oculto;
    }

}
