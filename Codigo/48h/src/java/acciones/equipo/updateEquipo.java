/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.equipo;

import WS.Equipo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.equipoDAO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author fedev
 */
public class updateEquipo extends ActionSupport {

    String nombre;
    String nomCorto;
   
    List<Equipo> listaEquipos = new ArrayList();

    public updateEquipo() {
    }

    public String getNombre() {
        return nombre;
    }

    @RequiredStringValidator(message = "Debe de insertar un nombre")
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

    @RequiredStringValidator(message = "Debe de insertar un nombre corto")
    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }

    public String execute() throws Exception {
        //Recuperamos el objeto Equipo que vamos a actualizar, cambiamos sus datos por los introducidos
        //y lo guardamos en el sistema
        Equipo e = new equipoDAO().encuentraEquipo(nombre);
        e.setNomCorto(nomCorto);
        new equipoDAO().updateEquipo(e);
        listaEquipos = new equipoDAO().listadoEquipos();
        return SUCCESS;
    }

}
