/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.partidos;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.partidosDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.Instalaciones;
import pojos.Partidos;

/**
 *
 * @author mjdom
 */
public class borrarPartidos extends ActionSupport {

    private String oculto;
    private List<Partidos> listaPartidos;
    List<Instalaciones> listaInstalaciones = new ArrayList();

    public List<Instalaciones> getListaInstalaciones() {
        return listaInstalaciones;
    }

    public void setListaInstalaciones(List<Instalaciones> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }
    public borrarPartidos() {
    }

    @Override
    public String execute() throws Exception {
        //Elimina un partido por su id y recarga el listado de partidos para la vista
        new partidosDAO().deletePartidos(Integer.parseInt(this.getOculto()));
        listaPartidos = new partidosDAO().listadoPartidos();
        listaInstalaciones = new partidosDAO().listadoInstalaciones();
        return SUCCESS;
    }

    public String getOculto() {
        return oculto;
    }

    public void setOculto(String oculto) {
        this.oculto = oculto;
    }

    public List<Partidos> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partidos> listaPartido) {
        this.listaPartidos = listaPartido;
    }

}
