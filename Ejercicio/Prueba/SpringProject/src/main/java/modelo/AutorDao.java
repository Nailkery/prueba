/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Autor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo_Rivera
 */
public class AutorDao implements AuthorService {

    private SessionFactory sessionFactory;

    @Override
    public void addAutor(String autor, int edad) {
        Session session = sessionFactory.openSession();
        Autor b = new Autor();
        b.setAutor_nombre(autor);
        b.setAutor_edad(edad);
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
    public void updateAutor(int id, String autor, int edad) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Autor b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from autor where id =" + id);
            b = (Autor) query.uniqueResult();
            b.setAutor_nombre(autor);
            b.setAutor_edad(edad);
            session.update(b);
        } catch (Exception e) {

        }
        session.close();

    }

    @Override
    public Autor getAutor(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Autor b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from autor where id =" + id);
            b = (Autor) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }
        session.close();
        return b;

    }

    @Override
    public List<Autor> getAutores() {
        List<Autor> l = null;
        String hql;
        Session session = sessionFactory.openSession();
        try {

            Query query = session.createQuery("from autor");
            if (!query.list().isEmpty()) {
                l = query.list();
            }
        } catch (Exception e) {
        }
        session.close();
        return l;
    }

    @Override
    public void deleteAutor(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Autor b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from autor where id =" + id);
            b = (Autor) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }

        session.close();
    }

    @Override
    public void addAutor(String autor, int edad, int idLibro) {
        Session session = sessionFactory.openSession();
        Autor b = new Autor();
        b.setAutor_nombre(autor);
        b.setAutor_edad(edad);

        try {
            session.save(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.close();
    }

}
