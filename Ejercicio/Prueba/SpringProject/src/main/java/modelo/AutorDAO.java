/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Autor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author luis
 */
public class AutorDAO{
    private SessionFactory sessionFactory;
    
    public void setSessionFactory (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public String insert(String nombre, int edad){
        Session session = sessionFactory.openSession();
//        Transaction tx = null;
        Autor a = new Autor();
        a.set(nombre, edad);
        try{
//            tx = session.beginTransaction();
            session.save(a);
//            Query query = session.createQuery("insert into autor values (:var , :var1)");
//            query.setParameter("var", nombre);
//            query.setParameter("var1", edad);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return nombre+ " agregado";
    }
    
    public String update(Autor a, String nombre, int edad){
        Session session = sessionFactory.openSession();
//        Transaction tx = null;
        try{
            //tx = session.beginTransaction();
            a.set(nombre, edad);
            session.update(a);
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
    
    
    
    public Autor porID(long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Autor lista = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from autor where id = :var");
            query.setParameter("var", id);
            lista = (Autor) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return lista;
    }
}
