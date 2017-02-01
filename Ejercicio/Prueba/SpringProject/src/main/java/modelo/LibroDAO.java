/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Autor;
import MapaeoBD.Biblioteca;
import MapaeoBD.Libro;
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
//        Transaction tx = null;
        Libro a = new Libro();
        a.set(nombre, paginas, b, a1);
        try{
//            tx = session.beginTransaction();
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
//        Transaction tx = null;
        l.set(nombre, paginas, b, a1);
        try{
//            tx = session.beginTransaction();
            session.update(l);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return nombre+ " actualizado";
    }
    
//    public String update(String nombre, int paginas, long biblioteca_id, long autor_id){
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Query query = session.createQuery("insert into libro values (:var , :var1, :var2, var3)");
//            query.setParameter("var", nombre);
//            query.setParameter("var1", paginas);
//            query.setParameter("var2", biblioteca_id);
//            query.setParameter("var1", autor_id);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            session.close();
//        }
//        return nombre+ " agregado";
//    }
    
    
}
