/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Autor;
import java.util.List;
import javax.websocket.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface AuthorService {

    public void addAutor(String autor, int edad);

    public void addAutor(String autor, int edad, int idLibro);

    public void updateAutor(int id, String autor, int edad);

    public Autor getAutor(int id);

    public void deleteAutor(int id);

    public List<Autor> getAutores();
}
