package accelerators.gestao.oficina.controladores;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accelerators.gestao.oficina.interfaces.IControladores;
import accelerators.gestao.oficina.modelos.Cliente;
import accelerators.gestao.oficina.servicos.ClienteServicos;

@Controller
@RequestMapping("/cliente")
public class ClienteController implements IControladores<Cliente, Integer> {

    private ClienteServicos cs;
    //cs é cliente serviços

    public ClienteController(ClienteServicos cs){
        this.cs = cs;
    }

    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("cliente/novo.html");
        mv.addObject("cliente", new Cliente());
        return mv;
    }

    @PostMapping("/novo")
    @Override
    public ModelAndView novo(Cliente obj) {
        obj = cs.novo(obj);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("cliente/index.html");
        mv.addObject("clientes", cs.todos());
        return mv;
    }

    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar(@PathVariable Integer chave) {
        ModelAndView mv = new ModelAndView("cliente/editar.html");
        mv.addObject("cliente", cs.buscaEdit(chave));
        return mv;
    }

    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Cliente obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/cliente");
        obj = cs.atualizar(obj);
        return mv;
    }

    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable Integer chave) {
        Optional<Cliente> cliente = cs.busca(chave);
        ModelAndView mv;
        if (cliente.isPresent()) {
            mv = new ModelAndView("cliente/excluir.html");
            mv.addObject("cliente", cliente);
        }
        else{
            mv = new ModelAndView("redirect:/cliente");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Cliente obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/cliente");
        cs.excluir(obj);
        return mv;
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable Integer id) {
        Optional<Cliente> cliente = cs.busca(id);
        ModelAndView mv;
        if (cliente.isPresent()){
            mv = new ModelAndView("cliente/detalhes.html");
            mv.addObject("cliente", cliente);
        }
        else{
            mv = new ModelAndView("redirect:/cliente");
        }
        return mv;
    }

}
