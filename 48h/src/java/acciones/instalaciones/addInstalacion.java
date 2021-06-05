/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.instalaciones;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.instalacionesDAO;
import java.util.List;
import pojos.Instalaciones;

/**
 *
 * @author mjdom
 */
public class addInstalacion extends ActionSupport {

    private String nombre;
    private String direccion;
    private String ciudad;
    private String longitud;
    private String latitud;
    private int capacidad;
    private List<Instalaciones> listaInstalaciones;

    public addInstalacion() {
    }

    public String execute() throws Exception {
        new instalacionesDAO().addInstalacion(this.getNombre(), this.getDireccion(), this.getCiudad(), this.getLongitud(), this.getLatitud(), this.getCapacidad());
        listaInstalaciones = new instalacionesDAO().listadoInstalaciones();
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    @RequiredStringValidator(message = "Debe de insertar un nombre de instalacion")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @RequiredStringValidator(message = "Debe de insertar una direccion de la instalacion")
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    
    @RequiredFieldValidator(message = "Debe insertar una capacidad de la instalacion")
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Instalaciones> getListaInstalaciones() {
        return listaInstalaciones;
    }

    public void setListaInstalaciones(List<Instalaciones> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }

}
