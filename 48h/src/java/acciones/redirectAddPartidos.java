/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import WS.Equipo;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import dao.equipoDAO;

/**
 *
 * @author mjdom
 */
public class redirectAddPartidos extends ActionSupport {

    private List<Equipo> listaEquipo;

    public redirectAddPartidos() {
    }

    public String execute() throws Exception {
        listaEquipo = new equipoDAO().listadoEquipos();
        return SUCCESS;
    }

    public List<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

}
