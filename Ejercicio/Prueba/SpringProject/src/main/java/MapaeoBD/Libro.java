/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapaeoBD;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo_Rivera
 */
@Entity
@Table(name = "libro") // si tiene que ir como en la de la base
public class Libro { // como sea  su nombre

    /**
     * "id" bigserial not null, "nombre" character varying(150) not null,
     * "paginas" integer not null, "biblioteca_id" bigint not null, "autor_id"
     * bigint not null ); todo lo que no sea intero en la base es long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //colmnas de la base 
    @Column(name = "id") // nombre de la columana 
    private long libro_id;// como lo vamos a manejar

    @Column(name = "nombre")
    private String libro_nombre;

    @Column(name = "paginas")
    private int libro_paginas;

    @ManyToOne
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;

    @OneToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
        this.libro_nombre = null;
        this.biblioteca = null;
        this.autor = null;
        this.libro_paginas=0;
    }

    public long getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(long libro_id) {
        this.libro_id = libro_id;
    }

    public String getLibro_nombre() {
        return libro_nombre;
    }

    public void setLibro_nombre(String libro_nombre) {
        this.libro_nombre = libro_nombre;
    }

    public int getLibro_Paginas() {
        return libro_paginas;
    }

    public void setLibro_Paginas(int libro_Paginas) {
        this.libro_paginas = libro_Paginas;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

}
