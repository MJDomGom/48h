/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fedev
 */
@Entity
@Table(name = "partidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p")
    , @NamedQuery(name = "Partidos.findByLocal", query = "SELECT p FROM Partidos p WHERE p.local = :local")
    , @NamedQuery(name = "Partidos.findByVisitante", query = "SELECT p FROM Partidos p WHERE p.visitante = :visitante")
    , @NamedQuery(name = "Partidos.findByIdPartido", query = "SELECT p FROM Partidos p WHERE p.idPartido = :idPartido")
    , @NamedQuery(name = "Partidos.findByResultado", query = "SELECT p FROM Partidos p WHERE p.resultado = :resultado")
    , @NamedQuery(name = "Partidos.findByFecha", query = "SELECT p FROM Partidos p WHERE p.fecha = :fecha")})
public class Partidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Local")
    private String local;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Visitante")
    private String visitante;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPartido")
    private Integer idPartido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "resultado")
    private String resultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToMany(mappedBy = "partidosCollection")
    private Collection<Instalaciones> instalacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartido")
    private Collection<Estadisticas> estadisticasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartido")
    private Collection<Jugados> jugadosCollection;

    public Partidos() {
    }

    public Partidos(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Partidos(Integer idPartido, String local, String visitante, String resultado, Date fecha) {
        this.idPartido = idPartido;
        this.local = local;
        this.visitante = visitante;
        this.resultado = resultado;
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

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Instalaciones> getInstalacionesCollection() {
        return instalacionesCollection;
    }

    public void setInstalacionesCollection(Collection<Instalaciones> instalacionesCollection) {
        this.instalacionesCollection = instalacionesCollection;
    }

    @XmlTransient
    public Collection<Estadisticas> getEstadisticasCollection() {
        return estadisticasCollection;
    }

    public void setEstadisticasCollection(Collection<Estadisticas> estadisticasCollection) {
        this.estadisticasCollection = estadisticasCollection;
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
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WS.Partidos[ idPartido=" + idPartido + " ]";
    }
    
}
