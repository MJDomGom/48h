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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedev
 */
@Entity
@Table(name = "integrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Integrante.findAll", query = "SELECT i FROM Integrante i")
    , @NamedQuery(name = "Integrante.findByDni", query = "SELECT i FROM Integrante i WHERE i.dni = :dni")
    , @NamedQuery(name = "Integrante.findByNombre", query = "SELECT i FROM Integrante i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Integrante.findByApellidos", query = "SELECT i FROM Integrante i WHERE i.apellidos = :apellidos")
    , @NamedQuery(name = "Integrante.findByDorsal", query = "SELECT i FROM Integrante i WHERE i.dorsal = :dorsal")})
public class Integrante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dorsal")
    private int dorsal;
    @JoinColumn(name = "nombreEquipo", referencedColumnName = "nombre")
    @ManyToOne(optional = false)
    private Equipo nombreEquipo;

    public Integrante() {
    }

    public Integrante(String dni) {
        this.dni = dni;
    }

    public Integrante(String dni, String nombre, String apellidos, int dorsal) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dorsal = dorsal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Equipo getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(Equipo nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Integrante)) {
            return false;
        }
        Integrante other = (Integrante) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WS.Integrante[ dni=" + dni + " ]";
    }
    
}
