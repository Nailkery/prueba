/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Lector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Rodrigo_Rivera
 */
public class LectorDao implements LectorService{
private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addLector(Lector lector) {
        getCurrentSession().save(lector);
    }

    @Override
    public void updateLector(Lector lector) {
        Lector lec = getLector((int) lector.getLector_id());
        lec.setLector_correo(lector.getLector_correo());
        lec.setLector_nombre(lector.getLector_nombre());
        getCurrentSession().update(lec);
    }

   

    @Override
    public List<Lector> getLector() {
        return (List<Lector>) getCurrentSession().createQuery("from lector");
    }

    @Override
    public Lector getLector(int id) {
        Lector lec = (Lector) getCurrentSession().get(Lector.class, id);
        return lec;
    }

    @Override
    public void deleteLector(int id) {
        Lector lector = getLector(id);
        if(lector != null){
            getCurrentSession().delete(lector);
        }
    }
    
}
