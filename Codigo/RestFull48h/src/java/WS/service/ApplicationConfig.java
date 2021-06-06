/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author fedev
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(WS.service.EquipoFacadeREST.class);
        resources.add(WS.service.EstadisticasFacadeREST.class);
        resources.add(WS.service.InstalacionesFacadeREST.class);
        resources.add(WS.service.IntegranteFacadeREST.class);
        resources.add(WS.service.JugadosFacadeREST.class);
        resources.add(WS.service.PartidosFacadeREST.class);
        resources.add(WS.service.UsuarioFacadeREST.class);
    }
    
}
