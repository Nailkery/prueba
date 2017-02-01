/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Lector;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo_Rivera
 */
public class LectorDao implements LectorService {

    private SessionFactory sessionFactory;

    @Override
    public void addLector(String correo, String nombre) {
        Session session = sessionFactory.openSession();
        Lector b = new Lector();
        b.setLector_correo(correo);
        b.setLector_nombre(nombre);
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
    public void updateLector(int id, String correo, String nombre) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Lector b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from lector where id =" + id);
            b = (Lector) query.uniqueResult();
            b.setLector_correo(correo);
            b.setLector_nombre(nombre);
            session.update(b);
        } catch (Exception e) {

        }
        session.close();
    }

    @Override
    public List<Lector> getLector() {
        List<Lector> l = null;
        String hql;
        Session session = sessionFactory.openSession();
        try {

            Query query = session.createQuery("from lector");
            if (!query.list().isEmpty()) {
                l = query.list();
            }
        } catch (Exception e) {
        }
        session.close();
        return l;
    }

    @Override
    public Lector getLector(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Lector b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from lector where id =" + id);
            b = (Lector) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }
        session.close();
        return b;
    }

    @Override
    public void deleteLector(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Lector b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from lector where id =" + id);
            b = (Lector) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }

        session.close();
    }

}
