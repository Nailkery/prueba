/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Autor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class AutorDAO{
    private SessionFactory sessionFactory;
    
    public void setSessionFactory (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
     
    /**
     * inserta un autor 
     * @param nombre
     * @param edad 
     */
    public void insert(String nombre, int edad){
        Session session = sessionFactory.openSession();
        Autor a = new Autor();
        a.set(nombre, edad);
        try{
            session.save(a);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        
    }
    
    /**
     * acutliza un autor 
     * @param a
     * @param nombre
     * @param edad 
     */
    public void update(Autor a, String nombre, int edad){
        Session session = sessionFactory.openSession();
        try{
            a.set(nombre, edad);
            session.update(a);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        
    }
    
    /**
     * actualiza un autopor por el id
     * @param id
     * @param nombre
     * @param edad 
     */
    public void uptdate(int id , String nombre ,int edad){
        Session session = sessionFactory.openSession();
        try {
            Autor a = AutorPorID(id);
            a.set(nombre, edad);
            session.update(a);
        } catch (Exception e) {
        }
            
    }
    
    /**
     * busca un autor por ID 
     * @param id
     * @return 
     */
    public Autor AutorPorID(long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Autor lista = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from Autor where id = :var");
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
