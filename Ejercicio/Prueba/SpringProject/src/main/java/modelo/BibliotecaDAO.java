/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Autor;
import MapaeoBD.Biblioteca;
import MapaeoBD.Libro;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author luis
 */
public class BibliotecaDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public String insert(String nombre){
        Session session = sessionFactory.openSession();
        Biblioteca a = new Biblioteca();
        a.setBiblioteca_nombre(nombre);
        try{
            session.save(a);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return nombre+ " agregado";
    }
    
    public String update(Biblioteca b, String nombre){
        Session session = sessionFactory.openSession();
        b.setBiblioteca_nombre(nombre);
        try{
            session.update(b);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return nombre+ " actualizado";
    }
    
    public List cont(Biblioteca b){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List l = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from libro where biblioteca_id = :var");
            query.setParameter("var", b.getBiblioteca_id());
            l = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return l;
    }
    
    public Biblioteca porNombre(String nombre){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Biblioteca lista = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from biblioteca where nombre = :var");
            query.setParameter("var", nombre);
            lista = (Biblioteca) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return lista;
    }
}
