/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author luis
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

    @OneToMany
    @JoinColumn(name = "id")
    private Set<Libro> l = new HashSet<>();

    /**
     * debe de tener get an set de cada varible y el contructor null
     */

    public Biblioteca() {
        this.biblioteca_nombre = null;
    }

    public long getBiblioteca_id() {
        return biblioteca_id;
    }

    public void setBiblioteca_id(long libro_id) {
        this.biblioteca_id = libro_id;
    }

    public String getBiblioteca_nombre() {
        return biblioteca_nombre;
    }

    public void setBiblioteca_nombre(String libro_nombre) {
        this.biblioteca_nombre = libro_nombre;
    }

}
