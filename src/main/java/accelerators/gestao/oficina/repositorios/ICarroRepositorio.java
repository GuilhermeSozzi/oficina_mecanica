package accelerators.gestao.oficina.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accelerators.gestao.oficina.modelos.Carro;

@Repository
public interface ICarroRepositorio extends JpaRepository<Carro,Integer> {
    List<Carro> findByPlaca(String placa);
}
