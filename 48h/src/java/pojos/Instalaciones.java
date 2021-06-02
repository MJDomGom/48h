package pojos;
// Generated 02-jun-2021 17:56:08 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Instalaciones generated by hbm2java
 */
public class Instalaciones  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String direccion;
     private int capacidad;
     private Set juegans = new HashSet(0);

    public Instalaciones() {
    }

	
    public Instalaciones(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
    }
    public Instalaciones(String nombre, String direccion, int capacidad, Set juegans) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.capacidad = capacidad;
       this.juegans = juegans;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Set getJuegans() {
        return this.juegans;
    }
    
    public void setJuegans(Set juegans) {
        this.juegans = juegans;
    }




}


