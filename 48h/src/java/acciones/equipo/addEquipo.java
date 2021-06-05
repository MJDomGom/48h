/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.equipo;

import WS.Equipo;
import WS.equipoCliente;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.equipoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedev
 */
public class addEquipo extends ActionSupport {
    Equipo nuevo = new Equipo();
    String nombre;
    String nomCorto;
     equipoCliente cliente = new equipoCliente();
    List<Equipo> listaEquipos = new ArrayList();
    public addEquipo() {
    }

    public Equipo getNuevo() {
        return nuevo;
    }

    public void setNuevo(Equipo nuevo) {
        this.nuevo = nuevo;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public String getNombre() {
        return nombre;
    }
    @RequiredStringValidator (message = "Debe especificar un nombre para el equipo")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomCorto() {
        return nomCorto;
    }
    @RequiredStringValidator (message = "Debe especificar un nombre abreviado para el equipo")
    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }
    
 
    @Override
    public String execute() throws Exception {
        nuevo.setNombre(nombre);
        nuevo.setNomCorto(nomCorto);
        new equipoDAO().addEquipo(nuevo);
        listaEquipos= new equipoDAO().listadoEquipos();
        return SUCCESS;
    }
    
}
