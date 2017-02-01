/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // nombre de la columana 
    private long autor_id;// como lo vamos a manejar

    @Column(name = "nombre")
    private String autor_nombre;

    @Column(name = "edad")
    private int autor_edad;
    
    @OneToOne
    @JoinColumn(name = "id")
    private Libro l;
    

    public Autor() {
        this.autor_nombre = null;
        this.autor_edad = 0;
    }

    public long getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(long autor_id) {
        this.autor_id = autor_id;
    }

    public String getAutor_nombre() {
        return autor_nombre;
    }

    public void setAutor_nombre(String autor_nombre) {
        this.autor_nombre = autor_nombre;
    }

    public int getAutor_edad() {
        return autor_edad;
    }

    public void setAutor_edad(int autor_edad) {
        this.autor_edad = autor_edad;
    }
    
    public void set(String nombre, int edad){
        this.autor_nombre = nombre;
        this.autor_edad = edad;
    }
    
    
}
