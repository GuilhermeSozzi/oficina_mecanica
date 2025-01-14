package accelerators.gestao.oficina.interfaces;

import org.springframework.web.servlet.ModelAndView;

public interface IControladores <T,K> {
    public ModelAndView novo();

    public ModelAndView novo(T obj);
    
    public ModelAndView listar();
    
    public ModelAndView editar(K chave);
    
    public ModelAndView editar(T obj,K chave);

    public ModelAndView excluir(K chave);

    public ModelAndView excluir(T obj, K chave);
}
