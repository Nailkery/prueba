/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Lector_Libro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo_Rivera
 */
public class LecorLibroDao implements LectorLibroService {

    private SessionFactory sessionFactory;

    @Override
    public void addLector_Libro(String comentario, int edad) {
        Session session = sessionFactory.openSession();
        Lector_Libro b = new Lector_Libro();
        b.setAutor_edad(edad);
        b.setLector_libro_comentario(comentario);
        try {
            session.save(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.close();
    }

    @Override
    public void updateLector_Libro(int id, String comentario, int edad) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Lector_Libro b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from lector_libro where id =" + id);
            b = (Lector_Libro) query.uniqueResult();
            b.setAutor_edad(edad);
            b.setLector_libro_comentario(comentario);
            session.update(b);
        } catch (Exception e) {

        }
        session.close();
    }

    @Override
    public Lector_Libro getLector_Libro(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Lector_Libro b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from lector_libro where id =" + id);
            b = (Lector_Libro) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }
        session.close();
        return b;
    }

    @Override
    public void deleteLector_Libro(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Lector_Libro b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from lector_libro where id =" + id);
            b = (Lector_Libro) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }

        session.close();
    }

    @Override
    public List<Lector_Libro> getLector_Libro() {
        List<Lector_Libro> l = null;
        String hql;
        Session session = sessionFactory.openSession();
        try {

            Query query = session.createQuery("from lector_libro");
            if (!query.list().isEmpty()) {
                l = query.list();
            }
        } catch (Exception e) {
        }
        session.close();
        return l;
    }

}
