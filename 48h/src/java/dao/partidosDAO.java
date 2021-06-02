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
import pojos.Jugados;
import pojos.Partidos;

/**
 *
 * @author mjdom
 */
public class partidosDAO {

    Session session = null;
    public List<Partidos> listaPartidos;
    public List<Jugados> listaJugados;

    public List<Partidos> listadoPartidos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Partidos");
        listaPartidos = (List<Partidos>) q.list();
        tx.commit();
        return listaPartidos;
    }

    public void deletePartidos(int oculto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Partidos where idPartido = '" + oculto + "'");
        Partidos borrar = (Partidos) q.uniqueResult();
        session.delete(borrar);
        tx.commit();
    }
}
