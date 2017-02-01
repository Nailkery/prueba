/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.AutorDao;
import modelo.BibliotecaDao;
import modelo.LecorLibroDao;
import modelo.LectorDao;
import modelo.LibroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Rodrigo_Rivera
 */
@Controller
public class Controlador {

    @Autowired
    private AutorDao autor_db;

    @Autowired

    private BibliotecaDao biblioteca_db;
    @Autowired
    private LecorLibroDao lectorLibro_db;

    @Autowired
    private LectorDao lecor_db;
    
    @Autowired
    private LibroDao libro_db;
}
