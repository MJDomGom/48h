/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.partidos;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.partidosDAO;
import java.util.List;
import pojos.Partidos;

/**
 *
 * @author mjdom
 */
public class borrarPartidos extends ActionSupport {

    private String oculto;
    private List<Partidos> listaPartidos;

    public borrarPartidos() {
    }

    public String execute() throws Exception {
        new partidosDAO().deletePartidos(Integer.parseInt(this.getOculto()));
        listaPartidos = new partidosDAO().listadoPartidos();
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
