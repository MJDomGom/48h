/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import WS.Equipo;
import WS.equipoCliente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author fedev
 */
public class equipoDAO {
    Equipo equipo ;
    List<Equipo>listaEquipos = new ArrayList();
    equipoCliente cliente = new equipoCliente();
    public List <Equipo> listadoEquipos(){
        GenericType<List<Equipo>> tipoGenerico = new GenericType<List<Equipo>>(){};
        listaEquipos = cliente.findAll_XML(tipoGenerico);
        return listaEquipos;
    }
    
    public void addEquipo (Equipo e){
        cliente.create_XML(e);
    }
    public void deleteEquipo(Equipo e){
        cliente.remove(e.getNombre());
    }
    public void updateEquipo (Equipo e){
//        GenericType<Equipo> tipoGenerico = new GenericType<Equipo>(){};
//        Equipo aux = cliente.find_XML(tipoGenerico, e.getNombre());
        cliente.edit_XML(e, e.getNombre());
    }
    public Equipo encuentraEquipo(String nombre){
        GenericType<Equipo> tipoGenerico = new GenericType<Equipo>(){};
         Equipo aux = cliente.find_XML(tipoGenerico, nombre);
         return aux;
    }
}
