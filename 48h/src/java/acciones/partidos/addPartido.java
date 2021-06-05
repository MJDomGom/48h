/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.partidos;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.instalacionesDAO;
import dao.partidosDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojos.Instalaciones;
import pojos.Juegan;
import pojos.JueganId;
import pojos.Partidos;

/**
 *
 * @author fedev
 */
public class addPartido extends ActionSupport {

    String resultado;
    String fecha;
    Partidos partido = new Partidos();
    List<Partidos> listaPartidos = new ArrayList<>();
    List<Instalaciones> listaInstalaciones = new ArrayList();
    String local;
    String visitante;
    String instalacion;

    public addPartido() {
    }

    public String getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public String getResultado() {
        return resultado;
    }

    @RequiredStringValidator(message = "Debe especificar un resultado")
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    @RequiredStringValidator(message = "Debe especificar una fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
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
    public void validate() {
        if (local.equals(visitante)) {
            addFieldError("local", "Local y visitante no pueden ser el mismo equipo");
        }
    }

    @Override
    public String execute() throws Exception {
        partido.setResultado(resultado);
        partido.setLocal(local);
        partido.setVisitante(visitante);
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaPartido = formato.parse(fecha);
        partido.setFecha(fechaPartido);
        new partidosDAO().addPartido(partido);
        listaPartidos = new partidosDAO().listadoPartidos();
        Instalaciones aux = new instalacionesDAO().getInstalacion(Integer.decode(instalacion));
        Juegan nuevo = new Juegan();
        JueganId jueganId = new JueganId(partido.getIdPartido(), aux.getId());
        nuevo.setId(jueganId);
        nuevo.setPartidos(partido);
        nuevo.setInstalaciones(aux);
        new partidosDAO().addJuegan(nuevo);
        listaInstalaciones = new partidosDAO().listadoInstalaciones();
        return SUCCESS;
    }

}
