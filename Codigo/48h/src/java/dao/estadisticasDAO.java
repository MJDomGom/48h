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
import pojos.Estadisticas;

/**
 *
 * @author mjdom
 */
public class estadisticasDAO {

    Session session = null;
    public List<Estadisticas> listaEstadisticas;

    public List<Estadisticas> listadoEstadisticas() {
        //Devuelve una lista con todas las estadisticas del sistema
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Estadisticas");
        listaEstadisticas = (List<Estadisticas>) q.list();
        tx.commit();
        return listaEstadisticas;
    }

    public void deleteEstadisticas(int oculto) {
        //elimina un elemento estadistica por su id
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Estadisticas where id = '" + oculto + "'");
        Estadisticas borrar = (Estadisticas) q.uniqueResult();
        session.delete(borrar);
        tx.commit();
    }

    public void addEstadisticas(Estadisticas esta) {
        //Añade una estadistica
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(esta);
        tx.commit();
    }

    public List<Estadisticas> updateEstadisticas(Estadisticas upd) {
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(upd);
        tx.commit();
        listaEstadisticas = listadoEstadisticas();
        return listaEstadisticas;
    }

    public Estadisticas getEstadistica(int oculto) {
        //Devuelve un objeto estadistica obtenido por su id
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Estadisticas upd = new Estadisticas();
        List<Estadisticas> listaEstadisticasUpd = listadoEstadisticas();

        for (int i = 0; i < listaEstadisticasUpd.size(); i++) {
            if (listaEstadisticasUpd.get(i).getId() == oculto) {
                upd = listaEstadisticasUpd.get(i);
            }
        }
        return upd;
    }

}
