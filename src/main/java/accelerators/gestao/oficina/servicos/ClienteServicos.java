package accelerators.gestao.oficina.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import accelerators.gestao.oficina.interfaces.IServicos;
import accelerators.gestao.oficina.modelos.Cliente;
import accelerators.gestao.oficina.repositorios.IClienteRepositorio;
import accelerators.gestao.oficina.utilitarios.CelularUtil;
import accelerators.gestao.oficina.utilitarios.CpfUtil;

@Service
public class ClienteServicos implements IServicos<Cliente,Integer> {

    private IClienteRepositorio cr;
    //cr é cliente repositorio
    public ClienteServicos(IClienteRepositorio cr) {
        this.cr = cr;
    }

    @Override
    public Cliente novo(Cliente cli) {
        cli.setCpf(CpfUtil.formatarCPF(cli.getCpf()));
        cli.setCelular(CelularUtil.formatarCelular(cli.getCelular()));
        return cr.save(cli);
    }

    @Override
    public Optional<Cliente> busca(Integer chave) {
        Optional<Cliente> cli = cr.findById(chave);
        return cli;
    }

    public Optional<Cliente> buscaEdit(Integer chave) {
        Optional<Cliente> cli = cr.findById(chave);
        cli.ifPresent(cliente -> {
            cliente.setCpf(CpfUtil.removerFormatacao(cliente.getCpf()));
            cliente.setCelular(CelularUtil.removerFormatacao(cliente.getCelular()));
        });
        return cli;
    }

    @Override
    public List<Cliente> buscaPorNome(String nome) {
        return cr.findByNome(nome);
    }

    @Override
    public List<Cliente> todos() {
        return cr.findAll();
    }

    @Override
    public Cliente atualizar(Cliente cli) {
        cli.setCpf(CpfUtil.formatarCPF(cli.getCpf()));
        cli.setCelular(CelularUtil.formatarCelular(cli.getCelular()));
        return cr.save(cli);
    }

    @Override
    public void excluir(Cliente cli) {
        cr.delete(cli);
    }

    @Override
    public void excluirCodigo(Integer chave) {
        cr.deleteById(chave);
    }

}
