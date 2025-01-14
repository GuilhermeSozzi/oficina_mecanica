package accelerators.gestao.oficina.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//por ser um controlador voltado ao menu, não implementa a interface comum aos demais controladores
public class PrincipalController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }
    
}
