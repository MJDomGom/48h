/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.partidos;

import WS.Equipo;
import com.opensymphony.xwork2.ActionSupport;
import dao.equipoDAO;
import dao.instalacionesDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.Instalaciones;

/**
 *
 * @author fedev
 */
public class addPartidosRedirect extends ActionSupport {
    List<Equipo> listaEquipos = new ArrayList();
    List<Instalaciones> listaInstalaciones = new ArrayList();

    public addPartidosRedirect() {
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public List<Instalaciones> getListaInstalaciones() {
        return listaInstalaciones;
    }

    public void setListaInstalaciones(List<Instalaciones> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }
    
    public String execute() throws Exception {
        listaEquipos = new equipoDAO().listadoEquipos();
        listaInstalaciones = new instalacionesDAO().listadoInstalaciones();
        return SUCCESS;
    }
    
}
