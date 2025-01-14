package accelerators.gestao.oficina.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import accelerators.gestao.oficina.interfaces.IServicos;
import accelerators.gestao.oficina.modelos.Marca;
import accelerators.gestao.oficina.repositorios.IMarcaRepositorio;

@Service
public class MarcaServicos implements IServicos<Marca,Integer> {

    private IMarcaRepositorio mr;
    public MarcaServicos(IMarcaRepositorio mr) {
        this.mr = mr;
    }

    @Override
    public Marca novo(Marca mar) {
        return mr.save(mar);
    }

    @Override
    public Optional<Marca> busca(Integer chave) {
        Optional<Marca> mar = mr.findById(chave);
        return mar;
    }

    public Optional<Marca> buscaEdit(Integer chave) {
        Optional<Marca> mar = mr.findById(chave);
        return mar;
    }

    @Override
    public List<Marca> buscaPorNome(String nome) {
        return mr.findByNome(nome);
    }

    @Override
    public List<Marca> todos() {
        return mr.findAll();
    }

    @Override
    public Marca atualizar(Marca mar) {
        return mr.save(mar);
    }

    @Override
    public void excluir(Marca mar) {
        mr.delete(mar);
    }

    @Override
    public void excluirCodigo(Integer chave) {
        mr.deleteById(chave);
    }

}
