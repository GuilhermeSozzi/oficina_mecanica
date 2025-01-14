package accelerators.gestao.oficina.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accelerators.gestao.oficina.interfaces.IControladores;
import accelerators.gestao.oficina.modelos.Moto;
import accelerators.gestao.oficina.modelos.Cliente;
import accelerators.gestao.oficina.modelos.Modelo;
import accelerators.gestao.oficina.servicos.MotoServicos;
import accelerators.gestao.oficina.servicos.ClienteServicos;
import accelerators.gestao.oficina.servicos.ModeloServicos;

@Controller
@RequestMapping("/moto")
public class MotoController implements IControladores<Moto, Integer> {

    private MotoServicos motoservs;
    private ModeloServicos mods;
    private ClienteServicos clis;
    //motoservs é moto serviços

    public MotoController(MotoServicos motoservs, ModeloServicos mods, ClienteServicos clis){
        this.motoservs = motoservs;
        this.mods = mods;
        this.clis = clis;
    }

    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("moto/novo.html");
        List<Modelo> modelos = mods.todos(); 
        mv.addObject("modelos", modelos);
        List<Cliente> clientes = clis.todos(); 
        mv.addObject("clientes", clientes);
        mv.addObject("moto", new Moto());
        return mv;
    }

    @PostMapping("/novo")
    @Override
    public ModelAndView novo(Moto obj) {
        obj = motoservs.novo(obj);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("moto/index.html");
        mv.addObject("motos", motoservs.todos());
        return mv;
    }

    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar(@PathVariable Integer chave) {
        ModelAndView mv = new ModelAndView("moto/editar.html");
        List<Modelo> modelos = mods.todos(); 
        mv.addObject("modelos", modelos);
        List<Cliente> clientes = clis.todos(); 
        mv.addObject("clientes", clientes);
        mv.addObject("moto", motoservs.busca(chave));
        return mv;
    }

    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Moto obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/moto");
        obj = motoservs.atualizar(obj);
        return mv;
    }

    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable Integer chave) {
        Optional<Moto> moto = motoservs.busca(chave);
        ModelAndView mv;
        if (moto.isPresent()) {
            mv = new ModelAndView("moto/excluir.html");
            mv.addObject("moto", moto);
        }
        else{
            mv = new ModelAndView("redirect:/moto");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Moto obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/moto");
        motoservs.excluir(obj);
        return mv;
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable Integer id) {
        Optional<Moto> moto = motoservs.busca(id);
        ModelAndView mv;
        if (moto.isPresent()){
            mv = new ModelAndView("moto/detalhes.html");
            mv.addObject("moto", moto);
        }
        else{
            mv = new ModelAndView("redirect:/moto");
        }
        return mv;
    }

}