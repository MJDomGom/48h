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
        //Se devuelve un listado de equipos con todos los registros Equipo de la base de datos
        GenericType<List<Equipo>> tipoGenerico = new GenericType<List<Equipo>>(){};
        listaEquipos = cliente.findAll_XML(tipoGenerico);
        return listaEquipos;
    }
    
    public void addEquipo (Equipo e){
        //Se añade un equipo
        cliente.create_XML(e);
    }
    public void deleteEquipo(Equipo e){
        //Se borra un equipo
        cliente.remove(e.getNombre());
    }
    public void updateEquipo (Equipo e){
        //Se actualiza un equipo
        cliente.edit_XML(e, e.getNombre());
    }
    public Equipo encuentraEquipo(String nombre){
        //Devuelve un equipo buscado por su nombre
        GenericType<Equipo> tipoGenerico = new GenericType<Equipo>(){};
         Equipo aux = cliente.find_XML(tipoGenerico, nombre);
         return aux;
    }
}
