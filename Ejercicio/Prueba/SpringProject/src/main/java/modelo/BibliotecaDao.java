/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Biblioteca;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rodrigo_Rivera
 */
public class BibliotecaDao implements BibliotecaService{

    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addBiblioteca(Biblioteca biblioteca) {
        getCurrentSession().save(biblioteca);
    }

    @Override
    public void updateBiblioteca(Biblioteca biblioteca) {
        Biblioteca bibliotecaActu = getBiblioteca((int) biblioteca.getLibro_id());
        bibliotecaActu.setLibro_nombre(biblioteca.getLibro_nombre());
        getCurrentSession().update(bibliotecaActu);
    }

    @Override
    public Biblioteca getBiblioteca(int id) {
        Biblioteca biblioteca = (Biblioteca) getCurrentSession().get(Biblioteca.class, id);
        return biblioteca;
    }

    @Override
    public List<Biblioteca> getBiblioteca() {
        return (List<Biblioteca>) getCurrentSession().createQuery("from biblioteca");
    }

    @Override
    public void deleteBiblioteca(int id) {
        Biblioteca biblioteca = getBiblioteca(id);
        if(biblioteca != null){
            getCurrentSession().delete(biblioteca);
        }
    }
    
}
