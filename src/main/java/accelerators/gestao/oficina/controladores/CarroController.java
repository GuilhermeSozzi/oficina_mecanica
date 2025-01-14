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
import accelerators.gestao.oficina.modelos.Carro;
import accelerators.gestao.oficina.modelos.Cliente;
import accelerators.gestao.oficina.modelos.Modelo;
import accelerators.gestao.oficina.servicos.CarroServicos;
import accelerators.gestao.oficina.servicos.ClienteServicos;
import accelerators.gestao.oficina.servicos.ModeloServicos;

@Controller
@RequestMapping("/carro")
public class CarroController implements IControladores<Carro, Integer> {

    private CarroServicos carservicos;
    private ModeloServicos mods;
    private ClienteServicos clis;
    //carservicos é carro serviços

    public CarroController(CarroServicos carservicos, ModeloServicos mods, ClienteServicos clis){
        this.carservicos = carservicos;
        this.mods = mods;
        this.clis = clis;
    }

    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("carro/novo.html");
        List<Modelo> modelos = mods.todos(); 
        mv.addObject("modelos", modelos);
        List<Cliente> clientes = clis.todos(); 
        mv.addObject("clientes", clientes);
        mv.addObject("carro", new Carro());
        return mv;
    }

    @PostMapping("/novo")
    @Override
    public ModelAndView novo(Carro obj) {
        obj = carservicos.novo(obj);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("carro/index.html");
        mv.addObject("carros", carservicos.todos());
        return mv;
    }

    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar(@PathVariable Integer chave) {
        ModelAndView mv = new ModelAndView("carro/editar.html");
        List<Modelo> modelos = mods.todos(); 
        mv.addObject("modelos", modelos);
        List<Cliente> clientes = clis.todos(); 
        mv.addObject("clientes", clientes);
        mv.addObject("carro", carservicos.busca(chave));
        return mv;
    }

    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Carro obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/carro");
        obj = carservicos.atualizar(obj);
        return mv;
    }

    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable Integer chave) {
        Optional<Carro> carro = carservicos.busca(chave);
        ModelAndView mv;
        if (carro.isPresent()) {
            mv = new ModelAndView("carro/excluir.html");
            mv.addObject("carro", carro);
        }
        else{
            mv = new ModelAndView("redirect:/carro");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Carro obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/carro");
        carservicos.excluir(obj);
        return mv;
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable Integer id) {
        Optional<Carro> carro = carservicos.busca(id);
        ModelAndView mv;
        if (carro.isPresent()){
            mv = new ModelAndView("carro/detalhes.html");
            mv.addObject("carro", carro);
        }
        else{
            mv = new ModelAndView("redirect:/carro");
        }
        return mv;
    }

}