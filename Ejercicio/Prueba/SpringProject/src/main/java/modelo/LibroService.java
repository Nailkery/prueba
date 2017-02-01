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

    public void addLibro(String nombre,int paginas);

    public void updateLibro(int id,String nombre,int paginas);

    public Libro getLibro(int id);
    public void deleteTeam(int id);

    public List<Libro> getLibro();
}
