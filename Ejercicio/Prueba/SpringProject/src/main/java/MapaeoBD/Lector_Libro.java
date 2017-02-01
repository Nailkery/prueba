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
@Table(name = "lector_libro")
public class Lector_Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id") // nombre de la columana 
    private long lector_libro_id;// como lo vamos a manejar

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;
    
    @ManyToOne
    @JoinColumn(name = "id_lector")
    private Lector lector;
    
    @Column(name = "nombre")
    private String lector_libro_comentario;

    @Column(name = "edad")
    private int autor_edad;

    public Lector_Libro() {
        this.lector_libro_comentario = null;
    }

    public long getLector_libro_id() {
        return lector_libro_id;
    }

    public void setLector_libro_id(long lector_libro_id) {
        this.lector_libro_id = lector_libro_id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public String getLector_libro_comentario() {
        return lector_libro_comentario;
    }

    public void setLector_libro_comentario(String lector_libro_comentario) {
        this.lector_libro_comentario = lector_libro_comentario;
    }

    public int getAutor_edad() {
        return autor_edad;
    }

    public void setAutor_edad(int autor_edad) {
        this.autor_edad = autor_edad;
    }
    
    
}
