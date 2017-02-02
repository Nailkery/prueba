
import MapeoBD.Autor;
import MapeoBD.Biblioteca;
import MapeoBD.Libro;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.AutorDao;
import modelo.BibliotecaDao;
import modelo.LecorLibroDao;
import modelo.LectorDao;
import modelo.LibroDao;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.RequestEntity.method;
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

    @RequestMapping(value = "/")
    public String index(ModelMap model) {

        return "datos";
    }

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

    /**
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/CrearAutor", method = RequestMethod.POST)
    public ModelAndView crearAutor(ModelMap model, HttpServletRequest request) {

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");

        autor_db.addAutor(nombre, Integer.parseInt(edad));
        model.addAttribute("nombre", nombre);

        return new ModelAndView("confimacion ", model);
    }

    @RequestMapping(value = "editarLbibro", method = RequestMethod.POST)

    public ModelAndView elimarAutor(ModelMap model, HttpServletRequest request) {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");;
        autor_db.updateAutor(Integer.parseInt(id), nombre, Integer.parseInt(edad));
        model.addAttribute("nombre", nombre);
        return new ModelAndView("confimacion ", model);
    }

    // crear libro 
    @RequestMapping(value = "crearLibro", method = RequestMethod.POST)
    public ModelAndView crearLibro(ModelMap model, HttpServletRequest request) {
        String nombre = request.getParameter("nombre");
        String paginas = request.getParameter("paginas");
        libro_db.addLibro(nombre, Integer.parseInt(paginas));
        model.addAttribute("nombre", nombre);
        return new ModelAndView("confimacion", model);
    }

    // editar libro
    @RequestMapping(value = "editarLibro", method = RequestMethod.POST)
    public ModelAndView ediatarLibro(ModelMap model, HttpServletRequest request) {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String paginas = request.getParameter("paginas");
        libro_db.updateLibro(Integer.parseInt(id), nombre, Integer.parseInt(paginas));
        model.addAttribute("nombre", nombre);
        return new ModelAndView("confimacion", model);
    }

    //crear bibilioteca
    @RequestMapping(value = "crearBiblioteca", method = RequestMethod.POST)
    public ModelAndView crearBiblioteca(ModelMap model, HttpServletRequest request) {

        String nombre = request.getParameter("nombre");
        biblioteca_db.addBiblioteca(nombre);
        model.addAttribute("nombre", nombre);
        return new ModelAndView("confimacion", model);
    }

    // ediar biblioteca
    @RequestMapping(value = "ediarBiblioteca", method = RequestMethod.POST)
    public ModelAndView editarBiblioteca(ModelMap model, HttpServletRequest request) {

        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        biblioteca_db.updateBiblioteca(Integer.parseInt(id), nombre);
        model.addAttribute("nombre", nombre);
        return new ModelAndView("confimacion", model);
    }

    //-Crear un libro asociado a la biblioteca
    @RequestMapping(value = "ediarBiblioteca", method = RequestMethod.POST)
    public ModelAndView creaLibroConbiblioteca(ModelMap model, HttpServletRequest request) {

        String libroNombre = request.getParameter("LibroNombre");
        String libropaginas = request.getParameter("libropaginas");
        String idBiblioteca = request.getParameter("idBiblioteca");

        libro_db.addLibro(libroNombre, Integer.parseInt(libropaginas), Integer.parseInt(idBiblioteca));
        model.addAttribute("nombre", libroNombre);
        return new ModelAndView("confimacion", model);

    }

    //-crear un autor asociado al libro
    @RequestMapping(value = "LibroAutor", method = RequestMethod.POST)
    public ModelAndView crearLibroAutor(ModelMap model, HttpServletRequest request) {

        String autorNombre = request.getParameter("autorNombre");
        String autorEdad = request.getParameter("autorEdad");
        String idBiblioteca = request.getParameter("idBiblioteca");

        libro_db.addLibroAutor(autorNombre, Integer.parseInt(autorEdad), Integer.parseInt(idBiblioteca));
        model.addAttribute("nombre", autorNombre);

        return new ModelAndView("confimacion", model);

    }

    //-mostrar una biblioteca y sus respectivos libros
    @RequestMapping(value = "bibliotecaLibros", method = RequestMethod.POST)
    public List<Libro> bibliotecaLibros(ModelMap model, HttpServletRequest request) {

        String idBiblioteca = request.getParameter("idBiblioteca");
        biblioteca_db.getBiblioteca(Integer.parseInt(idBiblioteca));
        return null;
    }
    //-registrar las lecturas de un lector
    
    @RequestMapping(value = "LecturasLector", method = RequestMethod.POST)
    public ModelAndView crearLecturasLector(ModelMap model, HttpServletRequest request) {

        
        String lectorID = request.getParameter("lectorId");
        String libroID = request.getParameter("libroID");
        lectorLibro_db.addLector_Libro(lectorID, 0);
        model.addAttribute("nombre", lectorID);

        return new ModelAndView("confimacion", model);

    }
    //-dado un lector mostrar los libros que ha leido
    
    @RequestMapping(value = "LibrosLeio", method = RequestMethod.POST)
    public ModelAndView mostrarLiborosLeidos(ModelMap model, HttpServletRequest request) {

        
        String lectorID = request.getParameter("lectorId");
        
        lectorLibro_db.addLector_Libro(lectorID, 0);
        model.addAttribute("nombre", lectorID);

        return new ModelAndView("confimacion", model);

    }
}
