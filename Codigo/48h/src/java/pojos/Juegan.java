package pojos;
// Generated 04-jun-2021 20:24:08 by Hibernate Tools 4.3.1



/**
 * Juegan generated by hbm2java
 */
public class Juegan  implements java.io.Serializable {


     private JueganId id;
     private Instalaciones instalaciones;
     private Partidos partidos;

    public Juegan() {
    }

    public Juegan(JueganId id, Instalaciones instalaciones, Partidos partidos) {
       this.id = id;
       this.instalaciones = instalaciones;
       this.partidos = partidos;
    }
   
    public JueganId getId() {
        return this.id;
    }
    
    public void setId(JueganId id) {
        this.id = id;
    }
    public Instalaciones getInstalaciones() {
        return this.instalaciones;
    }
    
    public void setInstalaciones(Instalaciones instalaciones) {
        this.instalaciones = instalaciones;
    }
    public Partidos getPartidos() {
        return this.partidos;
    }
    
    public void setPartidos(Partidos partidos) {
        this.partidos = partidos;
    }




}


