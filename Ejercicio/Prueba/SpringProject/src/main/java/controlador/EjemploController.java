package controlador;

import MapeoBD.Autor;
import MapeoBD.Biblioteca;
import MapeoBD.Lector;
import MapeoBD.Libro;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import modelo.AutorDAO;
import modelo.BibliotecaDAO;
import modelo.LectorDAO;
import modelo.Lector_LibroDAO;
import modelo.LibroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rae
 */
@Controller
public class EjemploController {

    @Autowired
    private AutorDAO autor_bd;

    @Autowired
    private BibliotecaDAO biblioteca_bd;

    @Autowired
    private LectorDAO lector_bd;

    @Autowired
    private Lector_LibroDAO lector_libro_bd;

    @Autowired
    private LibroDAO libro_bd;

    @RequestMapping(value = "/")
    public ModelAndView index(ModelMap model) {
        return new ModelAndView("confirmacion", model);
    }

    @RequestMapping(value = "/creaLibro", method = RequestMethod.POST)
    public ModelAndView creaLibro(ModelMap model, HttpServletRequest request) {
        String nombre = "";
        int pag = 1;
        int autorID = 1;
        int biliotecaID = 0;
        try {
            nombre = request.getParameter("nombre");
            pag = Integer.parseInt(request.getParameter("paginas"));
            autorID = Integer.parseInt(request.getParameter("autor_id"));
            biliotecaID = Integer.parseInt(request.getParameter("biliotecaID"));

        } catch (Exception e) {
            System.out.println("" + e);
            System.out.println(" error ");
            biliotecaID = 1;

        }

        //Biblioteca bi = biblioteca_bd.getID(5);
        Autor autor = autor_bd.AutorPorID(biliotecaID);
        Biblioteca bi = biblioteca_bd.getID(biliotecaID);
        libro_bd.insert(nombre, pag, bi, autor);
        model.addAttribute("nombre", nombre);
        model.addAttribute("id", pag);
//        long idB = biblioteca_bd.getID(Long.parseLong(idBilioteca)).getBiblioteca_id();
//        System.out.println("el numero es " + idB);
        return new ModelAndView("bilioteca", model);
    }

    @RequestMapping(value = "/buscarBiblioteca", method = RequestMethod.POST)
    public ModelAndView buscarBiblioteca(ModelMap model, HttpServletRequest request) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int id = Integer.parseInt(request.getParameter("id"));

        Biblioteca bi = biblioteca_bd.getID(id);
        model.addAttribute("id", bi.getBiblioteca_id());
        model.addAttribute("nombre", biblioteca_bd.getID(id).getBiblioteca_nombre());
        return new ModelAndView("bilioteca", model);
    }

    @RequestMapping(value = "/abotenerAutor", method = RequestMethod.POST)
    public ModelAndView abotenerAutor(ModelMap model, HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Autor autor = autor_bd.AutorPorID(id);

        model.addAttribute("id", autor.getAutor_id());
        model.addAttribute("nombre", autor.getAutor_nombre());
        return new ModelAndView("bilioteca", model);
    }

    /**
     *
     * -Editar el libro
     */
    @RequestMapping(value = "/editarLibro", method = RequestMethod.POST)
    public ModelAndView editarLibro(ModelMap model, HttpServletRequest request) {
        int libroId = Integer.parseInt(request.getParameter("idlibro"));
        String nombre = request.getParameter("nombre");
        int pag = Integer.parseInt(request.getParameter("paginas"));
        int biblioteca_id = Integer.parseInt(request.getParameter("biblioteca_id"));
        int autorId = Integer.parseInt(request.getParameter("autor_id"));

        Biblioteca bilbioteca = biblioteca_bd.getID(biblioteca_id);
        Autor autor = autor_bd.AutorPorID(autorId);
        Libro libro = libro_bd.porID(libroId);
        libro_bd.update(libro, nombre, pag, bilbioteca, autor);
        model.addAttribute("nombre", nombre);

        return new ModelAndView("confirmacion", model);
    }

    /**
     * *
     * crear biblioteca
     *
     * @param model
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/creaBiblioteca", method = RequestMethod.POST)
    public ModelAndView creaBiblioteca(ModelMap model, HttpServletRequest request) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        biblioteca_bd.insert(nombre);
        model.addAttribute("nombre", nombre);
        return new ModelAndView("confirmacion", model);
    }

    @RequestMapping(value = "/editarBiblioteca", method = RequestMethod.POST)
    public ModelAndView editarBiblioteca(ModelMap model, HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        System.out.println("-------------------antes de acutlizaar ");
        biblioteca_bd.update(biblioteca_bd.getID(id), nombre);
        System.out.println("despues de alculizar");
        model.addAttribute("nombre", nombre);
        return new ModelAndView("confirmacion", model);
    }

    /**
     * crear libro asiciado a una biblioteca
     */
    @RequestMapping(value = "/crearLibroConBiblioteca", method = RequestMethod.POST)
    public ModelAndView crearLibroConBiblioteca(ModelMap model, HttpServletRequest request) {
        String nombreLribro = "";
        int pagiansLibro = 0;
        int idBiblioteca = 0;
        int idAutor = 0;
        try {
            nombreLribro = request.getParameter("nombreLibro");
            pagiansLibro = Integer.parseInt(request.getParameter("paginasLibro"));
            idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca"));
            idAutor = Integer.parseInt(request.getParameter("idAutor"));

        } catch (Exception e) {
            System.out.println("error" + e);
            pagiansLibro = 10;
        }
        Biblioteca bibliote = biblioteca_bd.getID(idBiblioteca);
        Autor autor = autor_bd.AutorPorID(idAutor);

        libro_bd.insert(nombreLribro, pagiansLibro, bibliote, autor);

        model.addAttribute("nombre", nombreLribro);

        return new ModelAndView("confirmacion", model);
    }

    @RequestMapping(value = "/creaAutor", method = RequestMethod.POST)
    public ModelAndView creaAutor(ModelMap model, HttpServletRequest request) {
        String nombre = request.getParameter("nombreAutor");
        int edad = Integer.parseInt(request.getParameter("edadAutor"));
        autor_bd.insert(nombre, edad);

        model.addAttribute("nombre", nombre);

        return new ModelAndView("confirmacion", model);
    }

    /**
     * *
     * -crear un autor asociado al libro
     */
    @RequestMapping(value = "/mostrarLibrosBiblioteca", method = RequestMethod.POST)
    public ModelAndView mostrarLibrosBiblioteca(ModelMap model, HttpServletRequest request) {
        int idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca"));
        Biblioteca b = biblioteca_bd.getID(idBiblioteca);
        List<Libro> lista = biblioteca_bd.cont(b);
        model.addAttribute("nombre", lista);

        return new ModelAndView("confirmacion", model);
    }

    /**
     * -registrar comentario de un lector de un libro
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/registrarLecturas", method = RequestMethod.POST)
    public ModelAndView registrarLecturas(ModelMap model, HttpServletRequest request) {
        int idLecot = Integer.parseInt(request.getParameter("idLecot"));
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));
        String comentario = request.getParameter("comentario");
        Libro libro = libro_bd.porID(idLibro);
        Lector lector = lector_bd.getId(idLecot);
        lector_libro_bd.insert(lector, libro, comentario);
        model.addAttribute("nombreLector", idLecot);
        model.addAttribute("nombreLibro", idLibro);

        return new ModelAndView("confirmacion", model);
    }

    /**
     * dado un lector mostrar los libros que ha leido
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/mostrarLibrosdeLector", method = RequestMethod.POST)
    public ModelAndView mostrarLibrosdeLector(ModelMap model, HttpServletRequest request) {
        int idLector = Integer.parseInt(request.getParameter("idLector"));
        List lectorLib = lector_libro_bd.porLector(lector_bd.getId(idLector));

        model.addAttribute("nombre", lectorLib);

        return new ModelAndView("confirmacion", model);
    }
    /**
     * *
     *
     *
     * select * from biblioteca; select * from libro ; select * from autor;
     * select * from lector_libro; select * from lector; insert into libro
     * (nombre, paginas,biblioteca_id,autor_id)values('sebas',31,1,1); insert
     * into lector (nombre, correo,id_libro)values
     * ('rodrigo','rodrigo@ciencias.una',1); insert into autor (nombre ,edad)
     * values('karim',19);
     */
}
