/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.instalaciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.instalacionesDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.Instalaciones;

/**
 *
 * @author mjdom
 */
public class cargarInstalaciones extends ActionSupport {
    List<Instalaciones> listaInstalaciones = new ArrayList();
    
    public cargarInstalaciones() {
    }
    
    public String execute() throws Exception {
        listaInstalaciones = new instalacionesDAO().listadoInstalaciones();
        return SUCCESS;
    }

    public List<Instalaciones> getListaInstalaciones() {
        return listaInstalaciones;
    }

    public void setListaInstalaciones(List<Instalaciones> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }
    
    
}
