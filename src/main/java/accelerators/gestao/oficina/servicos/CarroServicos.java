package accelerators.gestao.oficina.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import accelerators.gestao.oficina.interfaces.IServicos;
import accelerators.gestao.oficina.modelos.Carro;
import accelerators.gestao.oficina.repositorios.ICarroRepositorio;

@Service
public class CarroServicos implements IServicos<Carro,Integer> {

    private ICarroRepositorio cr;
    public CarroServicos(ICarroRepositorio cr) {
        this.cr = cr;
    }

    @Override
    public Carro novo(Carro carro) {
        return cr.save(carro);
    }

    @Override
    public Optional<Carro> busca(Integer chave) {
        Optional<Carro> carro = cr.findById(chave);
        return carro;
    }

    @Override
    //se tornou busca por placa, na prática
    public List<Carro> buscaPorNome(String placa) {
        return cr.findByPlaca(placa);
    }

    @Override
    public List<Carro> todos() {
        return cr.findAll();
    }

    @Override
    public Carro atualizar(Carro carro) {
        return cr.save(carro);
    }

    @Override
    public void excluir(Carro carro) {
        cr.delete(carro);
    }

    @Override
    public void excluirCodigo(Integer chave) {
        cr.deleteById(chave);
    }

}
