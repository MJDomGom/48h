/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

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
public class updateEquipo extends ActionSupport {
    String nombre;
    String nomCorto;
    equipoCliente cliente = new equipoCliente();
    List<Equipo> listaEquipos = new ArrayList();
    public updateEquipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomCorto() {
        return nomCorto;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }
    
    public String execute() throws Exception {
        GenericType <Equipo> tipoGenerico = new GenericType <Equipo>(){};
        Equipo e = cliente.find_XML(tipoGenerico, nombre);
        e.setNomCorto(nomCorto);
        new equipoDAO().updateEquipo(e);        
        listaEquipos = new equipoDAO().listadoEquipos();
        return SUCCESS;
    }
    
}
