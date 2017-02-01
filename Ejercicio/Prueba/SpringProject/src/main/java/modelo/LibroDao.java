/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Libro;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rodrigo_Rivera
 */
public  class LibroDao implements LibroService{

   @Autowired
   private SessionFactory sessionFactory;

   private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addLibro(Libro libro) {
        getCurrentSession().save(libro);
    }

    
    @Override
    public void updateLibro(Libro libro) {
       Libro libroActua = getLibro((int) libro.getLibro_id());
       libroActua.setLibro_nombre(libro.getLibro_nombre());
       libroActua.setLibro_Paginas(libro.getLibro_Paginas());
       getCurrentSession().update(libroActua);
    }

    @Override
    public Libro getLibro(int id) {
        Libro libro = (Libro) getCurrentSession().get(Libro.class,id );
        return libro;
    }

    

    @Override
    public void deleteTeam(int id) {
        Libro libro = getLibro(id);
        if(libro != null){ // si no lo encuentra
              getCurrentSession().delete(libro);
        }
    }
    @Override
    public List<Libro> getLibro() {
     return (List<Libro>) getCurrentSession().createQuery("from libro");
    }
   
}
