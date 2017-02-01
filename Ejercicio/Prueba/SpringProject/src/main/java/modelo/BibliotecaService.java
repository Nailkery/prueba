/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapaeoBD.Autor;
import MapaeoBD.Biblioteca;
import java.util.List;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface BibliotecaService {
      public void addBiblioteca(String nombre);

    public void updateBiblioteca(int  id, String nombre);

    public Biblioteca getBiblioteca(int id);

    public void deleteBiblioteca(int id);
    public List<Biblioteca> getBiblioteca();
    
}
