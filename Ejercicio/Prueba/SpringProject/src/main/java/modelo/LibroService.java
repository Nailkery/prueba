/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Libro;
import java.util.List;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface LibroService {
      public void addAutor(Libro libro);

    public void updateAutor(Libro libro);

    public Libro getAutor(int id);

    public List<Libro> getAutores();
}