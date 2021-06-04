/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fedev
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Equipo.findByNomCorto", query = "SELECT e FROM Equipo e WHERE e.nomCorto = :nomCorto")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nomCorto")
    private String nomCorto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreEquipo")
    private Collection<Integrante> integranteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Jugados> jugadosCollection;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, String nomCorto) {
        this.nombre = nombre;
        this.nomCorto = nomCorto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomCorto() {
        return nomCorto;
    }

    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }

    @XmlTransient
    public Collection<Integrante> getIntegranteCollection() {
        return integranteCollection;
    }

    public void setIntegranteCollection(Collection<Integrante> integranteCollection) {
        this.integranteCollection = integranteCollection;
    }

    @XmlTransient
    public Collection<Jugados> getJugadosCollection() {
        return jugadosCollection;
    }

    public void setJugadosCollection(Collection<Jugados> jugadosCollection) {
        this.jugadosCollection = jugadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WS.Equipo[ nombre=" + nombre + " ]";
    }
    
}
