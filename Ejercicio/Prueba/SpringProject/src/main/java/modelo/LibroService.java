/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Biblioteca;
import MapeoBD.Libro;
import java.util.List;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface LibroService {

    public void addLibro(String nombre,int paginas);
    public void addLibro(String nombre,int paginas,int idBiblioteca);
    public void addLibroAutor(String nombre,int paginas,int idAutor);

    public void updateLibro(int id,String nombre,int paginas);

    public Libro getLibro(int id);
    public void deleteTeam(int id);

    public List<Libro> getLibro();
}
