/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Biblioteca;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rodrigo_Rivera
 */
public class BibliotecaDao implements BibliotecaService {

    private SessionFactory sessionFactory;

   

    @Override
    public void addBiblioteca(String nombre) {
        Session session = sessionFactory.openSession();
        Biblioteca a = new Biblioteca();
        a.setLibro_nombre(nombre);
        try {
            session.save(a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateBiblioteca(int id, String nombre) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Biblioteca b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from biblioteca where id =" + id);
            b = (Biblioteca) query.uniqueResult();
            b.setLibro_nombre(nombre);
            session.update(b);
        } catch (Exception e) {

        }

        session.close();

    }

    @Override
    public Biblioteca getBiblioteca(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Biblioteca b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from biblioteca where id =" + id);
            b = (Biblioteca) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }
        session.close();
        return b;
    }

    
    @Override
    public List<Biblioteca> getBiblioteca() {

        List<Biblioteca> l = null;
        String hql;
        Session session = sessionFactory.openSession();
        try {

            Query query = session.createQuery("from biblioteca");
            if (!query.list().isEmpty()) {
                l = query.list();
            }
        } catch (Exception e) {
        }
        session.close();
        return l;
    }

    @Override
    public void deleteBiblioteca(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Biblioteca b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from biblioteca where id =" + id);
            b = (Biblioteca) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }

        session.close();
    }

}
