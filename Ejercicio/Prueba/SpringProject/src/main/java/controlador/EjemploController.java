
package controlador;


import MapeoBD.Biblioteca;
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
public class EjemploController  {
    
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
    
    
    
   
    
    @RequestMapping(value="/")
    public ModelAndView index(ModelMap model){
        
       return new ModelAndView("confirmacion", model); 
    }
    
    @RequestMapping(value="/admin/creaBiblioteca", method = RequestMethod.POST)
    public ModelAndView creaBiblioteca(ModelMap model, HttpServletRequest request) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        biblioteca_bd.insert(nombre);
        model.addAttribute("nombre", nombre);        
        return new ModelAndView("bibCreada", model); 
    }
    
    @RequestMapping(value="/admin/creaLibro", method = RequestMethod.POST)
    public ModelAndView creaLibro(ModelMap model, HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        String pag = request.getParameter("pag");
        String bib = request.getParameter("bib");
        String autor = request.getParameter("autor");
        
        libro_bd.insert(nombre, Integer.parseInt(pag), biblioteca_bd.porNombre(bib), autor_bd.porNombre(autor));
        model.addAttribute("nombre", nombre);
        
        return new ModelAndView("confirmacion", model); 
    }
    
    @RequestMapping(value="/admin/editaLibro", method = RequestMethod.POST)
    public ModelAndView editaLibro(ModelMap model, HttpServletRequest request){
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String pag = request.getParameter("pag");
        String bib = request.getParameter("bib");
        String autor = request.getParameter("autor");
        
        libro_bd.update(libro_bd.porID(Long.parseLong(id)), nombre, Integer.parseInt(pag), biblioteca_bd.porNombre(bib), autor_bd.porNombre(autor));
        model.addAttribute("nombre", nombre);
        
        return new ModelAndView("confirmacion", model); 
    }
    
    @RequestMapping(value="/admin/creaAutor", method = RequestMethod.POST)
    public ModelAndView creaAutor(ModelMap model, HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        autor_bd.insert(nombre, Integer.parseInt(edad));
        model.addAttribute("nombre", nombre);
        
        return new ModelAndView("confirmacion", model); 
    }
    
    @RequestMapping(value="/admin/LibrosDeBiblioteca", method = RequestMethod.POST)
    public ModelAndView librosDeBiblioteca(ModelMap model, HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        Biblioteca b = biblioteca_bd.porNombre(nombre);
        List a = biblioteca_bd.cont(b);
        model.addAttribute("resultado", a);
        return new ModelAndView("confirmacion", model); 
    }
    
    @RequestMapping(value="/admin/registrarLecturas", method = RequestMethod.POST)
    public ModelAndView registrarLecturas(ModelMap model, HttpServletRequest request){
        String nombreLector = request.getParameter("nombreLector");
        String nombreLibro = request.getParameter("nombreLibro");
        String comentario = request.getParameter("comentario");
        
        lector_libro_bd.insert(lector_bd.porNombre(nombreLector), libro_bd.porNombre(nombreLibro), comentario);
        model.addAttribute("nombreLector", nombreLector);
        model.addAttribute("nombreLibro", nombreLibro);
        
        return new ModelAndView("confirmacion", model); 
    }
    
    @RequestMapping(value="/admin/librosLeidos", method = RequestMethod.POST)
    public ModelAndView librosLeidos(ModelMap model, HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        List a = lector_libro_bd.porLector(lector_bd.porNombre(nombre));
        model.addAttribute("nombre", nombre);
        model.addAttribute("lista", a);
        return new ModelAndView("confirmacion", model); 
    }
    
    /// mapeos 
    
    // modelos 
    
    // controlador 
    
      
}
