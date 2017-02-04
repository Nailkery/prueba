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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "lector") // si tiene que ir como en la de la base
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private int Lector_id;
    
    @Column(name = "nombre")
    private String Lector_nombre;
    
    @Column(name = "correo")
    private String Lector_correo;
            
    @OneToMany
    @JoinColumn(name ="id")
    private Set<Lector_Libro> lector_libro = new HashSet<>();

    
    /**
     * debe de tener get an set de cada varible y el contructor null
     */
    public Lector() {
        this.Lector_nombre = null;
        this.Lector_correo = null;
    }

    public int getLector_id() {
        return Lector_id;
    }

    public void setLector_id(int Lector_id) {
        this.Lector_id = Lector_id;
    }

    public String getLector_nombre() {
        return Lector_nombre;
    }

    public void setLector_nombre(String Lector_nombre) {
        this.Lector_nombre = Lector_nombre;
    }

    public String getLector_correo() {
        return Lector_correo;
    }

    public void setLector_correo(String Lector_correo) {
        this.Lector_correo = Lector_correo;
    }

    public Set<Lector_Libro> getLector_libro() {
        return lector_libro;
    }

    public void setLector_libro(Set<Lector_Libro> lector_libro) {
        this.lector_libro = lector_libro;
    }
    
    public void set(String nombre, String correo){
        this.Lector_nombre = nombre;
        this.Lector_correo = correo;
    }
    
}
