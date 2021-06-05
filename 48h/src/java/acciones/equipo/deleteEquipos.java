/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.equipo;

import WS.Equipo;
import WS.equipoCliente;
import com.opensymphony.xwork2.ActionSupport;
import dao.equipoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author fedev
 */
public class deleteEquipos extends ActionSupport {
    String oculto;
    String oculto1;
    List<Equipo> listaEquipos = new ArrayList<>();
    equipoCliente cli = new equipoCliente();
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
        GenericType <Equipo> tipoGenerico= new GenericType<Equipo>(){};
        Equipo e = cli.find_XML(tipoGenerico, oculto);
        new equipoDAO().deleteEquipo(e);
        listaEquipos = new equipoDAO().listadoEquipos();
        return SUCCESS;
    }
    
}
