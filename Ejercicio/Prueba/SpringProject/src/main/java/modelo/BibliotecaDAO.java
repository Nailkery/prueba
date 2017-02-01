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
//        Transaction tx = null;
        b.setBiblioteca_nombre(nombre);
        try{
//            tx = session.beginTransaction();
            session.update(b);
//            Query query = session.createQuery("insert into autor values (:var , :var1)");
//            query.setParameter("var", nombre);
//            query.setParameter("var1", edad);
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
}
