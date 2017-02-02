/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Lector_Libro;
import java.util.List;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface LectorLibroService {

    public void addLector_Libro(String comentario, int edad);

    public void updateLector_Libro(int id, String comentario, int edad);

    public Lector_Libro getLector_Libro(int id);

    public void deleteLector_Libro(int id);

    public List<Lector_Libro> getLector_Libro();
}