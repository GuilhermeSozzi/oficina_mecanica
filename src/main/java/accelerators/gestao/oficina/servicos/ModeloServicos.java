package accelerators.gestao.oficina.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import accelerators.gestao.oficina.interfaces.IServicos;
import accelerators.gestao.oficina.modelos.Modelo;
import accelerators.gestao.oficina.repositorios.IModeloRepositorio;

@Service
public class ModeloServicos implements IServicos<Modelo,Integer> {

    private IModeloRepositorio modr;
    public ModeloServicos(IModeloRepositorio modr) {
        this.modr = modr;
    }

    @Override
    public Modelo novo(Modelo mod) {
        return modr.save(mod);
    }

    @Override
    public Optional<Modelo> busca(Integer chave) {
        Optional<Modelo> mod = modr.findById(chave);
        return mod;
    }

    public Optional<Modelo> buscaEdit(Integer chave) {
        Optional<Modelo> mod = modr.findById(chave);
        return mod;
    }

    @Override
    public List<Modelo> buscaPorNome(String nome) {
        return modr.findByNome(nome);
    }

    @Override
    public List<Modelo> todos() {
        return modr.findAll();
    }

    @Override
    public Modelo atualizar(Modelo mod) {
        return modr.save(mod);
    }

    @Override
    public void excluir(Modelo mod) {
        modr.delete(mod);
    }

    @Override
    public void excluirCodigo(Integer chave) {
        modr.deleteById(chave);
    }

}
