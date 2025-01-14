package accelerators.gestao.oficina.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accelerators.gestao.oficina.modelos.Cliente;

@Repository
public interface IClienteRepositorio extends JpaRepository<Cliente,Integer> {
    List<Cliente> findByNome(String nome);
}
