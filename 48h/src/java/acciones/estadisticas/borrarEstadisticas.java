/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.estadisticas;

import com.opensymphony.xwork2.ActionSupport;
import dao.estadisticasDAO;
import java.util.List;
import pojos.Estadisticas;

/**
 *
 * @author mjdom
 */
public class borrarEstadisticas extends ActionSupport {

    private int oculto;
    private List<Estadisticas> listaEstadisticas;

    public borrarEstadisticas() {
    }

    public String execute() throws Exception {
        new estadisticasDAO().deleteEstadisticas(this.getOculto());
        listaEstadisticas = new estadisticasDAO().listadoEstadisticas();
        return SUCCESS;
    }

    public int getOculto() {
        return oculto;
    }

    public void setOculto(int oculto) {
        this.oculto = oculto;
    }

    public List<Estadisticas> getListaEstadisticas() {
        return listaEstadisticas;
    }

    public void setListaEstadisticas(List<Estadisticas> listaEstadisticas) {
        this.listaEstadisticas = listaEstadisticas;
    }

}
