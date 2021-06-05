/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.equipo;

import WS.Equipo;
import WS.Integrante;
import WS.equipoCliente;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author fedev
 */
public class updateEquiposRedirect extends ActionSupport {
    String oculto;
    String nombre;
    String nomCorto;
    equipoCliente cli = new equipoCliente();
    List<Integrante> listaIntegranteEquipo = new ArrayList();
    public updateEquiposRedirect() {
    }

    public List<Integrante> getListaIntegranteEquipo() {
        return listaIntegranteEquipo;
    }

    public void setListaIntegranteEquipo(List<Integrante> listaIntegranteEquipo) {
        this.listaIntegranteEquipo = listaIntegranteEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOculto() {
        return oculto;
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }

    public String getNomCorto() {
        return nomCorto;
    }

    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }
    
    public String execute() throws Exception {
        GenericType<Equipo> tipoGenerico = new GenericType<Equipo>(){};
        Equipo e = cli.find_XML(tipoGenerico, oculto);
        nombre = oculto;
        nomCorto = e.getNomCorto();
        listaIntegranteEquipo = (List<Integrante>) e.getIntegranteCollection();
        return SUCCESS;
    }
    
}
