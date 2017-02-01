/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapaeoBD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo_Rivera
 */
@Entity
@Table(name = "biblioteca") // si tiene que ir como en la de la base
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //colmnas de la base 
    @Column(name = "id") // nombre de la columana 
    private long biblioteca_id;// como lo vamos a manejar

    @Column(name = "nombre")
    private String biblioteca_nombre;

    public Biblioteca() {
        this.biblioteca_nombre = null;
    }
    

    public long getLibro_id() {
        return biblioteca_id;
    }

    public void setLibro_id(long libro_id) {
        this.biblioteca_id = libro_id;
    }

    public String getLibro_nombre() {
        return biblioteca_nombre;
    }

    public void setLibro_nombre(String libro_nombre) {
        this.biblioteca_nombre = libro_nombre;
    }
    
    
    
}
