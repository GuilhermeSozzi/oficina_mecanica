package accelerators.gestao.oficina.interfaces;

import java.util.List;
import java.util.Optional;

public interface IServicos<T,K> {
    T novo(T obj);

    Optional<T> busca(K chave);

    //esse busca por nome será adaptado para busca por placa para carro e moto (o nome permanece o mesmo)
    List<T> buscaPorNome(String nome);

    List<T> todos();

    T atualizar(T obj);

    void excluir(T obj);

    void excluirCodigo(K chave);
}
