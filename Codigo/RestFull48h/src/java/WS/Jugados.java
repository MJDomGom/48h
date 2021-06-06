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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedev
 */
@Entity
@Table(name = "jugados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugados.findAll", query = "SELECT j FROM Jugados j")
    , @NamedQuery(name = "Jugados.findById", query = "SELECT j FROM Jugados j WHERE j.id = :id")})
public class Jugados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idEquipo", referencedColumnName = "nombre")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "idPartido", referencedColumnName = "idPartido")
    @ManyToOne(optional = false)
    private Partidos idPartido;

    public Jugados() {
    }

    public Jugados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
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
        if (!(object instanceof Jugados)) {
            return false;
        }
        Jugados other = (Jugados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WS.Jugados[ id=" + id + " ]";
    }
    
}
