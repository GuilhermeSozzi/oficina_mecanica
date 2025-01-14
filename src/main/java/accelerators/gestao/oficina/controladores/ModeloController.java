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
import accelerators.gestao.oficina.modelos.Marca;
import accelerators.gestao.oficina.modelos.Modelo;
import accelerators.gestao.oficina.servicos.MarcaServicos;
import accelerators.gestao.oficina.servicos.ModeloServicos;

@Controller
@RequestMapping("/modelo")
public class ModeloController implements IControladores<Modelo, Integer> {

    private ModeloServicos mods;
    private MarcaServicos mars;

    public ModeloController(ModeloServicos mods, MarcaServicos mars){
        this.mods = mods;
        this.mars = mars;
    }

    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("modelo/novo.html");
        List<Marca> marcas = mars.todos(); 
        mv.addObject("marcas", marcas);
        mv.addObject("modelo", new Modelo());
        return mv;
    }

    @PostMapping("/novo")
    @Override
    public ModelAndView novo(Modelo obj) {
        obj = mods.novo(obj);
        ModelAndView mv = new ModelAndView("redirect:/modelo");
        return mv;
    }

    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("modelo/index.html");
        mv.addObject("modelo", mods.todos());
        return mv;
    }

    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar(@PathVariable Integer chave) {
        ModelAndView mv = new ModelAndView("modelo/editar.html");
        List<Marca> marcas = mars.todos(); 
        mv.addObject("marcas", marcas);
        mv.addObject("modelo", mods.buscaEdit(chave));
        return mv;
    }

    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Modelo obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/modelo");
        obj = mods.atualizar(obj);
        return mv;
    }

    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable Integer chave) {
        Optional<Modelo> modelo = mods.busca(chave);
        ModelAndView mv;
        if (modelo.isPresent()) {
            mv = new ModelAndView("modelo/excluir.html");
            mv.addObject("modelo", modelo);
        }
        else{
            mv = new ModelAndView("redirect:/modelo");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Modelo obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/modelo");
        mods.excluir(obj);
        return mv;
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable Integer id) {
        Optional<Modelo> modelo = mods.busca(id);
        ModelAndView mv;
        if (modelo.isPresent()){
            mv = new ModelAndView("modelo/detalhes.html");
            mv.addObject("modelo", modelo);
        }
        else{
            mv = new ModelAndView("redirect:/modelo");
        }
        return mv;
    }

}
