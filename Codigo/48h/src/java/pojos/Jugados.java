package pojos;
// Generated 04-jun-2021 20:24:08 by Hibernate Tools 4.3.1



/**
 * Jugados generated by hbm2java
 */
public class Jugados  implements java.io.Serializable {


     private Integer id;
     private Equipo equipo;
     private Partidos partidos;

    public Jugados() {
    }

    public Jugados(Equipo equipo, Partidos partidos) {
       this.equipo = equipo;
       this.partidos = partidos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Partidos getPartidos() {
        return this.partidos;
    }
    
    public void setPartidos(Partidos partidos) {
        this.partidos = partidos;
    }




}

