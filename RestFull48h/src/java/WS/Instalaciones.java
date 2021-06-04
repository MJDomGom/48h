/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "instalaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instalaciones.findAll", query = "SELECT i FROM Instalaciones i")
    , @NamedQuery(name = "Instalaciones.findById", query = "SELECT i FROM Instalaciones i WHERE i.id = :id")
    , @NamedQuery(name = "Instalaciones.findByNombre", query = "SELECT i FROM Instalaciones i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Instalaciones.findByDireccion", query = "SELECT i FROM Instalaciones i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Instalaciones.findByCapacidad", query = "SELECT i FROM Instalaciones i WHERE i.capacidad = :capacidad")})
public class Instalaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @JoinTable(name = "juegan", joinColumns = {
        @JoinColumn(name = "idInstalacion", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idPartido", referencedColumnName = "idPartido")})
    @ManyToMany
    private Collection<Partidos> partidosCollection;

    public Instalaciones() {
    }

    public Instalaciones(Integer id) {
        this.id = id;
    }

    public Instalaciones(Integer id, String nombre, String direccion, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public Collection<Partidos> getPartidosCollection() {
        return partidosCollection;
    }

    public void setPartidosCollection(Collection<Partidos> partidosCollection) {
        this.partidosCollection = partidosCollection;
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
        if (!(object instanceof Instalaciones)) {
            return false;
        }
        Instalaciones other = (Instalaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WS.Instalaciones[ id=" + id + " ]";
    }
    
}
