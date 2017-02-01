/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Autor;
import MapeoBD.Lector;
import MapeoBD.Lector_Libro;
import MapeoBD.Libro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author luis
 */
public class Lector_LibroDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public String insert(Lector a, Libro l, String coment){
        Session session = sessionFactory.openSession();
        Lector_Libro s = new Lector_Libro();
        s.set(l, a, coment);
        try{
            session.save(s);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return a+" leyó "+l;
    }
    
    public List porLector(Lector a){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List l = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("select nombre from libro where id in (select id_libro from lector_libro where id_lector = :var)");
            query.setParameter("var", a.getLector_id());
            l = query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return l;
    }
}
