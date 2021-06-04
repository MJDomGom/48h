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
        GenericType<List<Integrante>> tipoGenerico = new GenericType<List<Integrante>>() {
        };
        listaIntegrantesWS = cliente.findAll_XML(tipoGenerico);
        return listaIntegrantesWS;
    }
    public void addIntegrante(Integrante i){
        cliente.create_XML(i);
    }
    public void deleteIntegrante(String dni){
        cliente.remove(dni);
    }
    public void updateIntegrante(Integrante i){
        cliente.edit_XML(i, i.getDni());
    }
    public Integrante encuentraIntegrante(String dni){
        GenericType<Integrante> tipoGenerico = new GenericType<Integrante>() {
        };
        integranteWs = cliente.find_XML(tipoGenerico, dni);
        return integranteWs;
    }
//    public List<Integrante> listadoIntegrantesEquipo(String nombreEquipo) {
//        GenericType<List<Integrante>> tipoGenerico = new GenericType<List<Integrante>>() {
//        };
//        listaIntegrantesWS = cliente.find_XML(tipoGenerico, nombreEquipo);
//        return listaIntegrantesWS;
//    }
}
