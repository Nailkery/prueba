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
        String nombre = request.getParameter("nombre");
        String pag = request.getParameter("paginas");
        String idBilioteca = request.getParameter("idBilioteca");
        String autorLibro = request.getParameter("autor_id");
        Biblioteca blioteca = biblioteca_bd.getID(Integer.parseInt(idBilioteca));
        Autor autor = autor_bd.AutorPorID(Integer.parseInt(autorLibro));

        libro_bd.insert(nombre, Integer.parseInt(pag), blioteca, autor);
        model.addAttribute("nombre", nombre);

        return new ModelAndView("confirmacion", model);
    }

    /**
     *
     * -Editar el libro
     */
    @RequestMapping(value = "/editarLibro", method = RequestMethod.POST)
    public ModelAndView editarLibro(ModelMap model, HttpServletRequest request) {
        String idLibro = request.getParameter("idlibro");
        String nombre = request.getParameter("nombre");
        String pag = request.getParameter("paginas");
        String bib = request.getParameter("biblioteca_id");
        String autor = request.getParameter("autor_id");
        

        Biblioteca bibl = biblioteca_bd.getID(Integer.parseInt(bib));
        Autor aut = autor_bd.AutorPorID(Integer.parseInt(autor));

        libro_bd.update(libro_bd.porID(Integer.parseInt(idLibro)), nombre, Integer.parseInt(pag), bibl, aut);
        model.addAttribute("nombre", nombre);

        return new ModelAndView("confirmacion", model);
    }

    /**
     * *
     * crear biblioteca
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
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        System.out.println("-------------------antes de acutlizaar ");
        biblioteca_bd.update(biblioteca_bd.getID(Integer.parseInt(id)), nombre);

        model.addAttribute("nombre", nombre);
        return new ModelAndView("confirmacion", model);
    }

    /**
     * crear libro asiciado a una biblioteca
     */
    @RequestMapping(value = "/crearLibroConBiblioteca", method = RequestMethod.POST)
    public ModelAndView crearLibroConBiblioteca(ModelMap model, HttpServletRequest request) {

     
        String nombreLribro = request.getParameter("nombreLibro");
        int pagiansLibro = Integer.parseInt(request.getParameter("paginasLibro"));
        int idAutor = Integer.parseInt(request.getParameter("idAutor"));
        String idBiblioteca = request.getParameter("idBiblioteca");
        Biblioteca bibliote = biblioteca_bd.getID(Integer.parseInt(idBiblioteca));
        Autor autor = autor_bd.AutorPorID(idAutor);

        libro_bd.insert(nombreLribro, pagiansLibro, bibliote, autor);

        model.addAttribute("nombre", nombreLribro);

        return new ModelAndView("confirmacion", model);
    }

    @RequestMapping(value = "/creaAutor", method = RequestMethod.POST)
    public ModelAndView creaAutor(ModelMap model, HttpServletRequest request) {
        String nombre = request.getParameter("nombreAutor");
        String edad = request.getParameter("edadAutor");
        autor_bd.insert(nombre, Integer.parseInt(edad));
        
        model.addAttribute("nombre", nombre);

        return new ModelAndView("confirmacion", model);
    }
    
   

    /**
     * *
     * -crear un autor asociado al libro
     */
    @RequestMapping(value = "/mostrarLibrosBiblioteca", method = RequestMethod.POST)
    public ModelAndView mostrarLibrosBiblioteca(ModelMap model, HttpServletRequest request) {
        String idBiblioteca = request.getParameter("idBiblioteca");
        Biblioteca b = biblioteca_bd.getID(Integer.parseInt(idBiblioteca));
        List<Libro> lista = biblioteca_bd.cont(b);
        model.addAttribute("nombre", lista);

        return new ModelAndView("confirmacion", model);
    }
    
    /**
     * -registrar comentario de un lector de un libro
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value="/registrarLecturas", method = RequestMethod.POST)
    public ModelAndView registrarLecturas(ModelMap model, HttpServletRequest request){
        String idLecot = request.getParameter("idLecot");
        String idLibro = request.getParameter("idLibro");
        String comentario = request.getParameter("comentario");
         Libro libro =libro_bd.porID(Integer.parseInt(idLibro));
        Lector lector = lector_bd.getId(idLecot);
        lector_libro_bd.insert(lector,libro , comentario);
        model.addAttribute("nombreLector", idLecot);
        model.addAttribute("nombreLibro", idLibro);
        
        return new ModelAndView("confirmacion", model); 
    }
    /**
     * dado un lector mostrar los libros que ha leido
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value = "/mostrarLibrosdeLector", method = RequestMethod.POST)
    public ModelAndView mostrarLibrosdeLector(ModelMap model, HttpServletRequest request) {
        String idLector = request.getParameter("idLector");
        List lectorLib = lector_libro_bd.porLector(lector_bd.getId(idLector));

        model.addAttribute("nombre", lectorLib);

        return new ModelAndView("confirmacion", model);
    }
    /***
     * 
     * 
select * from biblioteca;
select * from libro ;
select * from autor;
select * from lector_libro;
select * from lector;
insert  into libro (nombre, paginas,biblioteca_id,autor_id)values('sebas',31,1,1);
insert  into lector (nombre, correo,id_libro)values ('rodrigo','rodrigo@ciencias.una',1);
insert  into autor (nombre ,edad)  values('karim',19);
     */
}
