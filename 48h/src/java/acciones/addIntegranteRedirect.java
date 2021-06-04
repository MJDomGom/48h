/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import WS.Equipo;
import WS.equipoCliente;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author fedev
 */
public class addIntegranteRedirect extends ActionSupport {
    List <Equipo> listaEquipo = new ArrayList<>();
    equipoCliente cliente = new equipoCliente();
    public addIntegranteRedirect() {
    }

    public List<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }
    
    @Override
    public String execute() throws Exception {
        GenericType<List<Equipo>> tipoGenerico = new GenericType<List<Equipo>>(){};
        listaEquipo = cliente.findAll_XML(tipoGenerico);
        return SUCCESS;
    }
    
}
