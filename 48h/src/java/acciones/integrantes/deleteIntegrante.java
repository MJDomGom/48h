/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.integrantes;

import WS.Integrante;
import com.opensymphony.xwork2.ActionSupport;
import dao.integranteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedev
 */
public class deleteIntegrante extends ActionSupport {
    String oculto;
    List<Integrante> listaIntegrante = new ArrayList();
    public deleteIntegrante() {
    }

    public String getOculto() {
        return oculto;
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }

    public List<Integrante> getListaIntegrante() {
        return listaIntegrante;
    }

    public void setListaIntegrante(List<Integrante> listaIntegrante) {
        this.listaIntegrante = listaIntegrante;
    }
    
    @Override
    public String execute() throws Exception {
        new integranteDAO().deleteIntegrante(oculto);
        listaIntegrante = new integranteDAO().listadoIntegrantes();
        return SUCCESS;
    }
    
}
