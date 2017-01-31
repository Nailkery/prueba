
package Controlador;


import java.util.List;
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
    
    
    
   
    
    @RequestMapping(value="/")
    public String index(ModelMap model){
        
       
        
        return "datos";
    }
      
}
