/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Biblioteca;
import MapeoBD.Libro;
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
public  class LibroDao implements LibroService{

   
   private SessionFactory sessionFactory;

  
    @Override
    public void addLibro(String nombre,int paginas) {
        Session session = sessionFactory.openSession();
        Libro b = new Libro();
        b.setLibro_Paginas(paginas);
        b.setLibro_nombre(nombre);
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
    public void updateLibro(int id,String nombre,int paginas) {
       Session session = sessionFactory.openSession();
        Transaction tx = null;
        Libro b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from libro where id =" + id);
            b = (Libro) query.uniqueResult();
          b.setLibro_Paginas(paginas);
        b.setLibro_nombre(nombre);
            session.update(b);
        } catch (Exception e) {

        }
        session.close();
    }

    @Override
    public Libro getLibro(int id) {
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        Libro b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from libro where id =" + id);
            b = (Libro) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }
        session.close();
        return b;
    }

    

    @Override
    public void deleteTeam(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Libro b = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from libro where id =" + id);
            b = (Libro) query.uniqueResult();
            session.delete(b);
        } catch (Exception e) {

        }

        session.close();
    }
    @Override
    public List<Libro> getLibro() {
        List<Libro> l = null;
        String hql;
        Session session = sessionFactory.openSession();
        try {

            Query query = session.createQuery("from libro");
            if (!query.list().isEmpty()) {
                l = query.list();
            }
        } catch (Exception e) {
        }
        session.close();
        return l;
     
    }

    /**
     * agregar lib
     * @param nombre
     * @param paginas
     * @param biblioteca 
     */
    
    @Override
    public void addLibro(String nombre, int paginas, int biblioteca) {
        Session session = sessionFactory.openSession();
        Libro b = new Libro();
        b.setLibro_Paginas(paginas);
        b.setLibro_nombre(nombre);
        BibliotecaDao a = new BibliotecaDao();
       
        b.setBiblioteca(a.getBiblioteca(biblioteca));
        try {
            session.save(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.close();
    }

    /**
     * 
     * @param nombre
     * @param paginas
     * @param idAutor 
     */
    @Override
    public void addLibroAutor(String nombre, int paginas, int idAutor) {
        Session session = sessionFactory.openSession();
        Libro b = new Libro();
        AutorDao a = new AutorDao();
        b.setLibro_Paginas(paginas);
        b.setLibro_nombre(nombre);
        b.setAutor(a.getAutor(idAutor));
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
