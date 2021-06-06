/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.equipo;

import WS.Equipo;
import com.opensymphony.xwork2.ActionSupport;
import dao.equipoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedev
 */
public class cargarEquipos extends ActionSupport {
    List<Equipo> listaEquipos = new ArrayList<>();
    public cargarEquipos() {
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    
    public String execute() throws Exception {
        //Se realiza la carga del listado de equipos para mostrarlos adecuadamente
        listaEquipos = new equipoDAO().listadoEquipos();
        return SUCCESS;
    }
    
}
