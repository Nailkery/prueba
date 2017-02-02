/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Lector;
import java.util.List;

/**
 *
 * @author Rodrigo_Rivera
 */
public interface LectorService {

    public void addLector(String correo, String nombre);

    public void updateLector(int id, String correo, String nombre);

    public Lector getLector(int id);

    public void deleteLector(int id);

    public List<Lector> getLector();
}
