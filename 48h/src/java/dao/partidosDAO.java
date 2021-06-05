/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import acciones.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Instalaciones;
import pojos.Juegan;
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
    public List<Juegan> listaJuegan;
    public List<Instalaciones> listaInstalaciones;
    public Partidos partido;

    public List<Partidos> listadoPartidos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Partidos");
        listaPartidos = (List<Partidos>) q.list();
        tx.commit();
        return listaPartidos;
    }

    public void addPartido(Partidos p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
    }

    public void deletePartidos(int oculto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Partidos where idPartido = '" + oculto + "'");
        Partidos borrar = (Partidos) q.uniqueResult();
        session.delete(borrar);
        tx.commit();
    }

    public List<Instalaciones> buscarInstalaciones(List<Partidos> listaPartidos, List<Juegan> listaJuegan) {
        List<Instalaciones> listaInstalaciones = new ArrayList<>();
        for (int i = 0; i < listaPartidos.size(); i++) {
            for (int j = 0; j < listaJuegan.size(); j++) {
                if (Objects.equals(listaPartidos.get(i).getIdPartido(), listaJuegan.get(j).getPartidos().getIdPartido())) {
                    listaInstalaciones.add(listaJuegan.get(j).getInstalaciones());
                }
            }
        }

        return listaInstalaciones;
    }

    public List<Juegan> listadoJuegan() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Juegan");
        listaJuegan = (List<Juegan>) q.list();
        tx.commit();
        return listaJuegan;
    }

    public Partidos buscarPartido(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Partidos Where idPartido=" + id);
        partido = (Partidos) q.uniqueResult();
        tx.commit();
        return partido;
    }

    public void addJuegan(Juegan j) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(j);
        tx.commit();
    }

    public List<Instalaciones> listadoInstalaciones() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("SELECT i.nombre FROM Instalaciones i, Partidos p, Juegan j WHERE p.idPartido = j.partidos and i.id = j.instalaciones");
        listaInstalaciones = (List<Instalaciones>) q.list();
        tx.commit();
        return listaInstalaciones;
    }
}
