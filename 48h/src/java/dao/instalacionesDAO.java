/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import acciones.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Instalaciones;

/**
 *
 * @author mjdom
 */
public class instalacionesDAO {
    
    Session session = null;
    public List<Instalaciones> listaInstalaciones;
 
    public List<Instalaciones> listadoInstalaciones() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Instalaciones");
        listaInstalaciones = (List<Instalaciones>) q.list();
        tx.commit();
        return listaInstalaciones;
    }

    public void borrarInstalaciones(int id) {
        listaInstalaciones = listadoInstalaciones();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Instalaciones where id = '" + id + "'");
        Instalaciones borrar = (Instalaciones) q.uniqueResult();
        session.delete(borrar);
        tx.commit();
    }

    public void addInstalacion(String nombre, String direccion, String ciudad, String longitud, String latitud, int capacidad) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Instalaciones inst = new Instalaciones(nombre, direccion, ciudad, longitud, latitud, capacidad);
        session.save(inst);
        tx.commit();
    }

    public Instalaciones getInstalacion(int oculto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Instalaciones upd = new Instalaciones();
        List<Instalaciones> listaInstalacionesUpd = listadoInstalaciones();

        for (int i = 0; i < listaInstalacionesUpd.size(); i++) {
            if (listaInstalacionesUpd.get(i).getId() == oculto) {
                upd = listaInstalacionesUpd.get(i);
            }
        }
        return upd;
    }

    public List<Instalaciones> updateInstalaciones(Instalaciones upd) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(upd);
        tx.commit();
        listaInstalaciones = listadoInstalaciones();
        return listaInstalaciones;
    }

}
