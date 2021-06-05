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
public class cargarIntegrantes extends ActionSupport {
    List<Integrante> listaIntegrante = new ArrayList();
    public cargarIntegrantes() {
    }

    public List<Integrante> getListaIntegrante() {
        return listaIntegrante;
    }

    public void setListaIntegrante(List<Integrante> listaIntegrante) {
        this.listaIntegrante = listaIntegrante;
    }
    
    @Override
    public String execute() throws Exception {
        listaIntegrante = new integranteDAO().listadoIntegrantes();
        return SUCCESS;
    }
    
}
