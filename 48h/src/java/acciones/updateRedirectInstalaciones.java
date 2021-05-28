/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.instalacionesDAO;
import java.util.Map;
import pojos.Instalaciones;

/**
 *
 * @author mjdom
 */
public class updateRedirectInstalaciones extends ActionSupport {

    private int oculto;
    private Instalaciones upd;
    private Map session;

    public updateRedirectInstalaciones() {
    }

    public String execute() throws Exception {
        upd = new instalacionesDAO().getInstalacion(this.getOculto());
        session = (Map) ActionContext.getContext().getSession();
        session.put("NombreUpd", upd.getNombre());
        session.put("DirUpd", upd.getDireccion());
        session.put("CapUpd", upd.getCapacidad());
        session.put("IdUpd", this.getOculto());
        return SUCCESS;
    }

    public int getOculto() {
        return oculto;
    }

    public void setOculto(int oculto) {
        this.oculto = oculto;
    }

    public Instalaciones getUpd() {
        return upd;
    }

    public void setUpd(Instalaciones upd) {
        this.upd = upd;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

}
