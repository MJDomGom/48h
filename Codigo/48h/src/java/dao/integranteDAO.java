/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import WS.Integrante;
import WS.integranteCliente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author fedev
 */
public class integranteDAO {

    Integrante integranteWs = new Integrante();
    pojos.Integrante integrantePojos;
    List<Integrante> listaIntegrantesWS = new ArrayList<>();
    integranteCliente cliente = new integranteCliente();

    public List<Integrante> listadoIntegrantes() {
        //devuelve una lista de integrantes
        GenericType<List<Integrante>> tipoGenerico = new GenericType<List<Integrante>>() {
        };
        listaIntegrantesWS = cliente.findAll_XML(tipoGenerico);
        return listaIntegrantesWS;
    }
    public void addIntegrante(Integrante i){
        //Añade un objeto integrante pasado desde parametros
        cliente.create_XML(i);
    }
    public void deleteIntegrante(String dni){
        //Elimina un integrante por su dni
        cliente.remove(dni);
    }
    public void updateIntegrante(Integrante i){
        //Actualiza un integrante
        cliente.edit_XML(i, i.getDni());
    }
    public Integrante encuentraIntegrante(String dni){
        //devuelve un integrante buscado por su dni
        GenericType<Integrante> tipoGenerico = new GenericType<Integrante>() {
        };
        integranteWs = cliente.find_XML(tipoGenerico, dni);
        return integranteWs;
    }
}
