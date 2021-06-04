/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import WS.Equipo;
import WS.Integrante;
import com.opensymphony.xwork2.ActionSupport;
import dao.equipoDAO;
import dao.integranteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedev
 */
public class updateIntegranteRedirect extends ActionSupport {
    String oculto;

    String nombre;
    String apellidos;
    int dorsal;
    String equipo;
    List <Equipo> listaEquipo = new ArrayList<>();
    Integrante i = new Integrante();

    public List<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }
    
    public String getOculto() {
        return oculto;
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public updateIntegranteRedirect() {
    }
    
    @Override
    public String execute() throws Exception {
        i = new integranteDAO().encuentraIntegrante(oculto);
        nombre = i.getNombre();
        dorsal = i.getDorsal();
        apellidos = i.getApellidos();
        Equipo e = i.getNombreEquipo();
        equipo = e.getNombre();
        listaEquipo = new equipoDAO().listadoEquipos();
        return SUCCESS;
    }
    
}
