/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedev
 */
@Entity
@Table(name = "estadisticas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadisticas.findAll", query = "SELECT e FROM Estadisticas e")
    , @NamedQuery(name = "Estadisticas.findById", query = "SELECT e FROM Estadisticas e WHERE e.id = :id")
    , @NamedQuery(name = "Estadisticas.findByGolesTot", query = "SELECT e FROM Estadisticas e WHERE e.golesTot = :golesTot")
    , @NamedQuery(name = "Estadisticas.findByTirosPuerta", query = "SELECT e FROM Estadisticas e WHERE e.tirosPuerta = :tirosPuerta")
    , @NamedQuery(name = "Estadisticas.findByAmarillas", query = "SELECT e FROM Estadisticas e WHERE e.amarillas = :amarillas")
    , @NamedQuery(name = "Estadisticas.findByRojas", query = "SELECT e FROM Estadisticas e WHERE e.rojas = :rojas")
    , @NamedQuery(name = "Estadisticas.findByAzules", query = "SELECT e FROM Estadisticas e WHERE e.azules = :azules")})
public class Estadisticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "golesTot")
    private int golesTot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tirosPuerta")
    private int tirosPuerta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amarillas")
    private int amarillas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rojas")
    private int rojas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "azules")
    private int azules;
    @JoinColumn(name = "idPartido", referencedColumnName = "idPartido")
    @ManyToOne(optional = false)
    private Partidos idPartido;

    public Estadisticas() {
    }

    public Estadisticas(Integer id) {
        this.id = id;
    }

    public Estadisticas(Integer id, int golesTot, int tirosPuerta, int amarillas, int rojas, int azules) {
        this.id = id;
        this.golesTot = golesTot;
        this.tirosPuerta = tirosPuerta;
        this.amarillas = amarillas;
        this.rojas = rojas;
        this.azules = azules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGolesTot() {
        return golesTot;
    }

    public void setGolesTot(int golesTot) {
        this.golesTot = golesTot;
    }

    public int getTirosPuerta() {
        return tirosPuerta;
    }

    public void setTirosPuerta(int tirosPuerta) {
        this.tirosPuerta = tirosPuerta;
    }

    public int getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public int getRojas() {
        return rojas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    public int getAzules() {
        return azules;
    }

    public void setAzules(int azules) {
        this.azules = azules;
    }

    public Partidos getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Partidos idPartido) {
        this.idPartido = idPartido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadisticas)) {
            return false;
        }
        Estadisticas other = (Estadisticas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WS.Estadisticas[ id=" + id + " ]";
    }
    
}
