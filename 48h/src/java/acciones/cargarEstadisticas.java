/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import dao.estadisticasDAO;
import java.util.List;
import pojos.Estadisticas;

/**
 *
 * @author mjdom
 */
public class cargarEstadisticas extends ActionSupport {
    
    private List<Estadisticas> listaEstadisticas;
    
    public cargarEstadisticas() {
    }
    
    public String execute() throws Exception {
        listaEstadisticas = new estadisticasDAO().listadoEstadisticas();
        return SUCCESS;
    }

    public List<Estadisticas> getListaEstadisticas() {
        return listaEstadisticas;
    }

    public void setListaEstadisticas(List<Estadisticas> listaEstadisticas) {
        this.listaEstadisticas = listaEstadisticas;
    }
    
    
    
    
}
