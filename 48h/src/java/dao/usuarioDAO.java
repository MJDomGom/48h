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
import pojos.Usuario;

/**
 *
 * @author mjdom
 */
public class usuarioDAO {

    Session session = null;
    
    public List<Usuario> listaUsuarios;


    public Usuario comprobarLogin(String nick, String password) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Usuario where nick='" + nick + "' and password='" + password + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }

    public List<Usuario> listarUsuarios() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Usuario");
        listaUsuarios = q.list();
        tx.commit();
        return listaUsuarios;
    }

}
