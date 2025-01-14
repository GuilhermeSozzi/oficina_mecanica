package accelerators.gestao.oficina.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import accelerators.gestao.oficina.modelos.Marca;

@Repository
public interface IMarcaRepositorio extends JpaRepository<Marca,Integer> {
    List<Marca> findByNome(String nome);
}
