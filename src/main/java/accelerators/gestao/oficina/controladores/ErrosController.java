package accelerators.gestao.oficina.controladores;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//esse controlador será responsável por cuidar da exibição de erros ao usuário
@ControllerAdvice
public class ErrosController {
    
    //erro específico
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView illegalException(IllegalArgumentException ex){
        ModelAndView mv = new ModelAndView("erro.html");
        mv.addObject("mensagem", ex.getMessage());
        return mv;
    } 
    
    //erro na integridade do BD
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView dataIntegrityViolationException(DataIntegrityViolationException ex){
      ModelAndView mv = new ModelAndView("erro.html");
      mv.addObject("mensagem", "Erro de integridade referencial: A operação não pôde ser concluída. Soluções possíveis: \n" 
      +"1) Evite repetir dados únicos, como CPF, e-mail, número de celular, placa e chassi de veículo. \n"
      +"2) Elementos que estejam presentes em múltiplas tabelas não podem ser apagados, pois isso fere a integridade referencial. \n"
      +"Se ainda assim quiser apagá-los, apague primeiro suas dependências.");
      return mv;
    }

    //erro genérico
    @ExceptionHandler(Exception.class)
    public ModelAndView genericException(Exception ex){
      ModelAndView mv = new ModelAndView("erro.html");
      mv.addObject("mensagem", "Ocorreu um erro inesperado. Por favor, tente novamente.");
      return mv; 
    }
}
