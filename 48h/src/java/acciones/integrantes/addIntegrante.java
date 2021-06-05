/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.integrantes;

import WS.Equipo;
import WS.Integrante;
import WS.equipoCliente;
import WS.integranteCliente;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.integranteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author fedev
 */
public class addIntegrante extends ActionSupport {

    String dni;
    String nombre;
    String apellidos;
    int dorsal;
    String equipo;
    equipoCliente clienteEq = new equipoCliente();
    List<Integrante> listaIntegrante = new ArrayList();
    Integrante nuevo = new Integrante();
    Equipo eq = new Equipo();
    integranteCliente cliente = new integranteCliente();

    public String getDni() {
        return dni;
    }

    @RequiredStringValidator(message = "Debe especificar un dni")
    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Integrante> getListaIntegrante() {
        return listaIntegrante;
    }

    public void setListaIntegrante(List<Integrante> listaIntegrante) {
        this.listaIntegrante = listaIntegrante;
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

    @RequiredStringValidator(message = "Debe especificar unos apellidos")
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    @RequiredStringValidator(message = "Debe especificar un dorsal")
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public addIntegrante() {
    }

    @Override
    public String execute() throws Exception {
        eq.setNombre(equipo);
        nuevo.setApellidos(apellidos);
        nuevo.setDni(dni);
        nuevo.setDorsal(dorsal);
        nuevo.setNombre(nombre);
        GenericType<Equipo> tipoGenerico = new GenericType<Equipo>() {
        };
        eq = clienteEq.find_XML(tipoGenerico, equipo);
        nuevo.setNombreEquipo(eq);
        cliente.create_XML(nuevo);
        listaIntegrante = new integranteDAO().listadoIntegrantes();
        return SUCCESS;
    }

}
