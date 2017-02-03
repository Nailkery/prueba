/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Autor;
import MapeoBD.Biblioteca;
import MapeoBD.Libro;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author luis
 */
public class LibroDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public String insert(String nombre, int paginas, Biblioteca b, Autor a1){
        Session session = sessionFactory.openSession();
        Libro a = new Libro();
        a.set(nombre, paginas, b, a1);
        try{
            session.save(a);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return nombre+ " agregado";
    }
   
    public String update(Libro l, String nombre, int paginas, Biblioteca b, Autor a1){
        Session session = sessionFactory.openSession();
        l.set(nombre, paginas, b, a1);
        try{
            session.update(l);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return nombre+ " actualizado";
    }
    
    public Libro porID(long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Libro lista = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from libro where id = :var");
            query.setParameter("var", id);
            lista = (Libro) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return lista;
    }
    
    public Libro porNombre(String nombre){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Libro lista = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from libro where nombre = :var");
            query.setParameter("var", nombre);
            lista = (Libro) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return lista;
    }
    
}
