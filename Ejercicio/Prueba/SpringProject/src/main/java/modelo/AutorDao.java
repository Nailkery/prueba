/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Autor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Rodrigo_Rivera
 */
public class AutorDao implements AuthorService {

    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAutor(Autor autor) {
        getCurrentSession().save(autor);
    }

    @Override
    public void updateAutor(Autor autor) {
        Autor autorActulizado = getAutor((int) autor.getAutor_id());
        autorActulizado.setAutor_nombre(autor.getAutor_nombre());
        autorActulizado.setAutor_edad(autor.getAutor_edad());
        getCurrentSession().update(autor);

    }

    @Override
    public Autor getAutor(int id) {

        Autor autor = (Autor) getCurrentSession().get(Autor.class, id);
        return autor;
    }

    @Override
    public List<Autor> getAutores() {
        return  (List<Autor>) getCurrentSession().createQuery("from autor");
    }

    @Override
    public void deleteAutor(int id) {
        Autor autor = getAutor(id);
        if(autor != null){
            getCurrentSession().delete(autor);
        }
    }

}
