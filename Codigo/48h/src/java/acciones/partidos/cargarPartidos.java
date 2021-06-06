/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.partidos;


import com.opensymphony.xwork2.ActionSupport;
import dao.equipoDAO;
import dao.partidosDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.Instalaciones;
import pojos.Partidos;

/**
 *
 * @author fedev
 */
public class cargarPartidos extends ActionSupport {

    List<Partidos> listaPartidos;
    List<Instalaciones> listaInstalaciones = new ArrayList();
    public cargarPartidos() {
    }
    
    public List<Partidos> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partidos> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public List<Instalaciones> getListaInstalaciones() {
        return listaInstalaciones;
    }

    public void setListaInstalaciones(List<Instalaciones> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }

    @Override
    public String execute() throws Exception {
        //Carga el listado de partidos para la vista
        listaPartidos = new partidosDAO().listadoPartidos();
        listaInstalaciones = new partidosDAO().listadoInstalaciones();
        return SUCCESS;
    }

}
