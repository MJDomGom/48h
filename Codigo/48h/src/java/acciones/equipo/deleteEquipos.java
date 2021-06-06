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
public class deleteEquipos extends ActionSupport {
    String oculto;
    String oculto1;
    List<Equipo> listaEquipos = new ArrayList<>();
    public String getOculto() {
        return oculto;
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public String getOculto1() {
        return oculto1;
    }

    public void setOculto1(String oculto1) {
        this.oculto1 = oculto1;
    }
    
    public deleteEquipos() {
    }
    
    @Override
    public String execute() throws Exception {
        //Eliminamos un equipo del sistema directamente desde la tabla en la que se muestran
        Equipo e = new equipoDAO().encuentraEquipo(oculto);
        new equipoDAO().deleteEquipo(e);
        listaEquipos = new equipoDAO().listadoEquipos();
        return SUCCESS;
    }
    
}
