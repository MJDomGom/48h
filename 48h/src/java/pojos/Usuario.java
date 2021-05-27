package pojos;
// Generated 27-may-2021 19:55:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String nick;
     private String nombre;
     private String password;
     private String rol;
     private Set partidoses = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nick, String nombre, String password, String rol) {
        this.nick = nick;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }
    public Usuario(String nick, String nombre, String password, String rol, Set partidoses) {
       this.nick = nick;
       this.nombre = nombre;
       this.password = password;
       this.rol = rol;
       this.partidoses = partidoses;
    }
   
    public String getNick() {
        return this.nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Set getPartidoses() {
        return this.partidoses;
    }
    
    public void setPartidoses(Set partidoses) {
        this.partidoses = partidoses;
    }




}


