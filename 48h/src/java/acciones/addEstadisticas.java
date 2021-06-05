/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.estadisticasDAO;
import dao.partidosDAO;
import java.util.List;
import pojos.Estadisticas;
import pojos.Partidos;

/**
 *
 * @author mjdom
 */
public class addEstadisticas extends ActionSupport {

    private int partido;
    private String golesTot;
    private String tirosPuerta;
    private String amarillas;
    private String rojas;
    private String azules;
    private List<Estadisticas> listaEstadisticas;

    public addEstadisticas() {
    }

    public String execute() throws Exception {
        //Estadisticas add = new Estadisticas(this.getPartidos(), this.getGolesTot(), this.getTirosPuerta(), this.getAmarillas(), this.getRojas(), this.getAzules());
        //new estadisticasDAO().addEstadisticas(add);
        Partidos par = new partidosDAO().buscarPartido(this.partido);
        if (par != null) {
            Estadisticas add = new Estadisticas(par, this.getGolesTot(), this.getTirosPuerta(), this.getAmarillas(), this.getRojas(), this.getAzules());
            new estadisticasDAO().addEstadisticas(add);
            listaEstadisticas = new estadisticasDAO().listadoEstadisticas();
            return SUCCESS;
        } else {
            addFieldError("Partido", "No existe un partido con esa id");
            return ERROR;
        }
    }

    public String getGolesTot() {
        return golesTot;
    }

    @RequiredStringValidator(message = "Debe de insertar un resultado")
    public void setGolesTot(String golesTot) {
        this.golesTot = golesTot;
    }

    public String getTirosPuerta() {
        return tirosPuerta;
    }

    @RequiredStringValidator(message = "Debe de insertar unos goles totales")
    public void setTirosPuerta(String tirosPuerta) {
        this.tirosPuerta = tirosPuerta;
    }

    public String getAmarillas() {
        return amarillas;
    }

    @RequiredStringValidator(message = "Debe de insertar amarillas")
    public void setAmarillas(String amarillas) {
        this.amarillas = amarillas;
    }

    public String getRojas() {
        return rojas;
    }

    @RequiredStringValidator(message = "Debe de insertar rojas")
    public void setRojas(String rojas) {
        this.rojas = rojas;
    }

    public String getAzules() {
        return azules;
    }

    @RequiredStringValidator(message = "Debe de insertar azules")
    public void setAzules(String azules) {
        this.azules = azules;
    }

    public List<Estadisticas> getListaEstadisticas() {
        return listaEstadisticas;
    }

    public void setListaEstadisticas(List<Estadisticas> listaEstadisticas) {
        this.listaEstadisticas = listaEstadisticas;
    }

    public int getPartido() {
        return partido;
    }

    @RequiredFieldValidator(message = "Debe insertar un id del partido")
    public void setPartido(int partido) {
        this.partido = partido;
    }

}
