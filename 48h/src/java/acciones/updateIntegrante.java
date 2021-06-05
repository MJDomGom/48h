/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import WS.Equipo;
import WS.Integrante;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.equipoDAO;
import dao.integranteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedev
 */
public class updateIntegrante extends ActionSupport {

    String oculto;
    String nombre;
    String apellidos;
    int dorsal;
    String equipo;
    List<Integrante> listaIntegrante = new ArrayList();
    Integrante nuevo = new Integrante();

    public List<Integrante> getListaIntegrante() {
        return listaIntegrante;
    }

    public void setListaIntegrante(List<Integrante> listaIntegrante) {
        this.listaIntegrante = listaIntegrante;
    }

    public updateIntegrante() {
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

    @RequiredStringValidator(message = "Debe especificar un nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    @RequiredStringValidator(message = "Debe de insertar unos apellidos")
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

    @Override
    public String execute() throws Exception {
        nuevo.setDni(oculto);
        nuevo.setDorsal(dorsal);
        nuevo.setApellidos(apellidos);
        nuevo.setNombre(nombre);
        Equipo e = new equipoDAO().encuentraEquipo(equipo);
        nuevo.setNombreEquipo(e);
        new integranteDAO().updateIntegrante(nuevo);
        listaIntegrante = new integranteDAO().listadoIntegrantes();
        return SUCCESS;
    }

}
