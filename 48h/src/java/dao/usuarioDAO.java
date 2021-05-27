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

    public void addUsuario(String nick, String nombre, String password) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        String rol = "Gerente";
        Transaction tx = session.beginTransaction();
        Usuario user = new Usuario(nick, nombre, password, rol);
        session.save(user);
        tx.commit();
    }

    public void deleteUsuario(String oculto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Usuario del = new Usuario();
        del.setNick(oculto);
        Transaction tx = session.beginTransaction();
        session.delete(del);
        tx.commit();
    }

    public Usuario getUsuario(String oculto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Usuario upd = new Usuario();
        List<Usuario> listaUsuariosUpd = listarUsuarios();
        for (int i = 0; i < listaUsuariosUpd.size(); i++) {
            if (listaUsuariosUpd.get(i).getNick().equals(oculto)) {
                upd = listaUsuariosUpd.get(i);
            }
        }
        return upd;
    }

    public List<Usuario> updateUsuario(Usuario upd) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(upd);
        tx.commit();
        listaUsuarios = listarUsuarios();
        return listaUsuarios;
    }

}
