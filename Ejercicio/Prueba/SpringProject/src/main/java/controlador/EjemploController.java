
package controlador;


import java.util.List;
import modelo.AutorDAO;
import modelo.BibliotecaDAO;
import modelo.LectorDAO;
import modelo.Lector_LibroDAO;
import modelo.LibroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rae
 */
@Controller
public class EjemploController{
    
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
    public String index(ModelMap model){
        
       
        
        return "datos";
    }
    
    
    /// mapeos 
    
    // modelos 
    
    // controlador 
    
      
}
