/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Autor;
import MapaeoBD.Biblioteca;
import MapaeoBD.Lector;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author luis
 */
public class LectorDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public String insert(String nombre, String correo){
        Session session = sessionFactory.openSession();
        Lector a = new Lector();
        a.set(nombre, correo);
        try{
            session.save(a);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return nombre+ " agregado";
    }
    
    public Lector porNombre(String nombre){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Lector lista = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from lector where nombre = :var");
            query.setParameter("var", nombre);
            lista = (Lector) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return lista;
    }
    
}
