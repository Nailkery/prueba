/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Lector;
import java.util.List;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface LectorService {
      public void addLector(Lector lector);

    public void updateLector(Lector lector);

    public Lector getAutor(int id);

    public List<Lector> getLector();
}
