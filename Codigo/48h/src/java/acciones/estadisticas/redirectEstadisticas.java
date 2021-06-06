/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.estadisticas;

import com.opensymphony.xwork2.ActionSupport;
import dao.partidosDAO;
import java.util.List;
import pojos.Partidos;

/**
 *
 * @author mjdom
 */
public class redirectEstadisticas extends ActionSupport {

    private List<Partidos> listaPartidos;

    public redirectEstadisticas() {
    }

    public String execute() throws Exception {        
        listaPartidos = new partidosDAO().listadoPartidos();
        return SUCCESS;
    }

    public List<Partidos> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partidos> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

}
