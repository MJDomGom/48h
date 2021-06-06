/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.equipo;

import WS.Equipo;
import WS.Integrante;
import com.opensymphony.xwork2.ActionSupport;
import dao.equipoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedev
 */
public class updateEquiposRedirect extends ActionSupport {
    String oculto;
    String nombre;
    String nomCorto;
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
    
    @Override
    public String execute() throws Exception {
        //Redirigimos hacia la página para modificar equipos llevándo los campos necesarios ya rellenos
        Equipo e = new equipoDAO().encuentraEquipo(oculto);
        nombre = oculto;
        nomCorto = e.getNomCorto();
        return SUCCESS;
    }
    
}
