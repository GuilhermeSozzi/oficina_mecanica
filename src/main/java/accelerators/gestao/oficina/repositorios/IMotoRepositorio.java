package accelerators.gestao.oficina.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accelerators.gestao.oficina.modelos.Moto;

@Repository
public interface IMotoRepositorio extends JpaRepository<Moto,Integer> {
    List<Moto> findByPlaca(String placa);
}
