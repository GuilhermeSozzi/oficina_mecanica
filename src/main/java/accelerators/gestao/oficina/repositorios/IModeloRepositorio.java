package accelerators.gestao.oficina.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accelerators.gestao.oficina.modelos.Modelo;

@Repository
public interface IModeloRepositorio extends JpaRepository<Modelo,Integer> {
    List<Modelo> findByNome(String nome);
}
