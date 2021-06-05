/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.instalaciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.instalacionesDAO;
import java.util.List;
import java.util.Map;
import pojos.Instalaciones;

/**
 *
 * @author mjdom
 */
public class borrarInstalaciones extends ActionSupport {

    private Map session;
    private int oculto;
    private List<Instalaciones> listaInstalaciones;

    public borrarInstalaciones() {
    }

    public String execute() throws Exception { 
        new dao.instalacionesDAO().borrarInstalaciones(this.getOculto());
        listaInstalaciones = new instalacionesDAO().listadoInstalaciones();
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

    public List<Instalaciones> getListaInstalaciones() {
        return listaInstalaciones;
    }

    public void setListaInstalaciones(List<Instalaciones> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }

}
