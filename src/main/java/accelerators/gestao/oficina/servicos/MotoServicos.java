package accelerators.gestao.oficina.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import accelerators.gestao.oficina.interfaces.IServicos;
import accelerators.gestao.oficina.modelos.Moto;
import accelerators.gestao.oficina.repositorios.IMotoRepositorio;

@Service
public class MotoServicos implements IServicos<Moto,Integer> {

    private IMotoRepositorio motorepo;
    public MotoServicos(IMotoRepositorio motorepo) {
        this.motorepo = motorepo;
    }

    @Override
    public Moto novo(Moto moto) {
        return motorepo.save(moto);
    }

    @Override
    public Optional<Moto> busca(Integer chave) {
        Optional<Moto> moto = motorepo.findById(chave);
        return moto;
    }

    @Override
    //se tornou busca por placa, na prática
    public List<Moto> buscaPorNome(String placa) {
        return motorepo.findByPlaca(placa);
    }

    @Override
    public List<Moto> todos() {
        return motorepo.findAll();
    }

    @Override
    public Moto atualizar(Moto moto) {
        return motorepo.save(moto);
    }

    @Override
    public void excluir(Moto moto) {
        motorepo.delete(moto);
    }

    @Override
    public void excluirCodigo(Integer chave) {
        motorepo.deleteById(chave);
    }

}
