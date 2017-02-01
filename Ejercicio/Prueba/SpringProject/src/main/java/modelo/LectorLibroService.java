/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Lector_Libro;
import java.util.List;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface LectorLibroService {
      public void addAutor(Lector_Libro lectorLibro);

    public void updateAutor(Lector_Libro lectorLibro);

    public Lector_Libro getAutor(int id);

    public List<Lector_Libro> getAutores();
}
