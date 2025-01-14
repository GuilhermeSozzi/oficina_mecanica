package accelerators.gestao.oficina.controladores;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accelerators.gestao.oficina.interfaces.IControladores;
import accelerators.gestao.oficina.modelos.Marca;
import accelerators.gestao.oficina.servicos.MarcaServicos;

@Controller
@RequestMapping("/marca")
public class MarcaController implements IControladores<Marca, Integer> {

    private MarcaServicos ms;

    public MarcaController(MarcaServicos ms){
        this.ms = ms;
    }

    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("marca/novo.html");
        mv.addObject("marca", new Marca());
        return mv;
    }

    @PostMapping("/novo")
    @Override
    public ModelAndView novo(Marca obj) {
        obj = ms.novo(obj);
        ModelAndView mv = new ModelAndView("redirect:/marca");
        return mv;
    }

    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("marca/index.html");
        mv.addObject("marca", ms.todos());
        return mv;
    }

    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar(@PathVariable Integer chave) {
        ModelAndView mv = new ModelAndView("marca/editar.html");
        mv.addObject("marca", ms.buscaEdit(chave));
        return mv;
    }

    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Marca obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/marca");
        obj = ms.atualizar(obj);
        return mv;
    }

    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable Integer chave) {
        Optional<Marca> marca = ms.busca(chave);
        ModelAndView mv;
        if (marca.isPresent()) {
            mv = new ModelAndView("marca/excluir.html");
            mv.addObject("marca", marca);
        }
        else{
            mv = new ModelAndView("redirect:/marca");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Marca obj, Integer chave) {
        ModelAndView mv = new ModelAndView("redirect:/marca");
        ms.excluir(obj);
        return mv;
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable Integer id) {
        Optional<Marca> marca = ms.busca(id);
        ModelAndView mv;
        if (marca.isPresent()){
            mv = new ModelAndView("marca/detalhes.html");
            mv.addObject("marca", marca);
        }
        else{
            mv = new ModelAndView("redirect:/marca");
        }
        return mv;
    }

}
