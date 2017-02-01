/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Lector_Libro;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Rodrigo_Rivera
 */
public class LecorLibroDao implements LectorLibroService{
private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addLector_Libro(Lector_Libro lectorLibro) {
        getCurrentSession().save(lectorLibro);
    }

    @Override
    public void updateLector_Libro(Lector_Libro lectorLibro) {
         Lector_Libro lector = getLector_Libro((int)lectorLibro.getLector_libro_id());
         lector.setAutor_edad(lectorLibro.getAutor_edad());
         lector.setLector_libro_comentario(lectorLibro.getLector_libro_comentario());
         getCurrentSession().update(lector);
    }

    @Override
    public Lector_Libro getLector_Libro(int id) {
       Lector_Libro lectorLibro= (Lector_Libro) getCurrentSession().get(Lector_Libro.class, id);
       return lectorLibro;
    }

    @Override
    public void deleteLector_Libro(int id) {
        Lector_Libro lectorLibro = getLector_Libro(id);
        if(lectorLibro != null){
            getCurrentSession().delete(lectorLibro);
        }
    }

    @Override
    public List<Lector_Libro> getLector_Libro() {
        return (List<Lector_Libro>) getCurrentSession().createQuery("from lector_libro ");
    }

  
    
}
