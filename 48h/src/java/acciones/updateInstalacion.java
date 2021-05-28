/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import dao.instalacionesDAO;
import java.util.List;
import java.util.Map;
import pojos.Instalaciones;

/**
 *
 * @author mjdom
 */
public class updateInstalacion extends ActionSupport {
    
    private String nombreUpd;
    private String dirUpd;
    private int capUpd;
    private int idUpd;
    private Map session;
    private List<Instalaciones> listaInstalaciones;
    
    public updateInstalacion() {
    }
    
    public String execute() throws Exception {
        Instalaciones upd = new Instalaciones(this.getNombreUpd(), this.getDirUpd(), this.getCapUpd());
        upd.setId(this.getIdUpd());
        listaInstalaciones = new instalacionesDAO().updateInstalaciones(upd);
        return SUCCESS;
    }
    
    public String getNombreUpd() {
        return nombreUpd;
    }
    
    @RequiredStringValidator(message = "Debe de insertar un nombre de instalacion")
    public void setNombreUpd(String nombreUpd) {
        this.nombreUpd = nombreUpd;
    }
    
    public String getDirUpd() {
        return dirUpd;
    }
    
    @RequiredStringValidator(message = "Debe de insertar una direccion de la instalacion")
    public void setDirUpd(String dirUpd) {
        this.dirUpd = dirUpd;
    }
    
    public int getCapUpd() {
        return capUpd;
    }
    
    @RequiredFieldValidator(message = "Debe insertar una capacidad de la instalacion")
    public void setCapUpd(int capUpd) {
        this.capUpd = capUpd;
    }
    
    public Map getSession() {
        return session;
    }
    
    public void setSession(Map session) {
        this.session = session;
    }
    
    public List<Instalaciones> getListaInstalaciones() {
        return listaInstalaciones;
    }
    
    public void setListaInstalaciones(List<Instalaciones> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }
    
    public int getIdUpd() {
        return idUpd;
    }
    
    public void setIdUpd(int idUpd) {
        this.idUpd = idUpd;
    }
    
}
