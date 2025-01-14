package accelerators.gestao.oficina.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("Carro")
public class Carro extends Veiculo {
    @Column(name = "vei_numeroPortas", nullable = true)
    private int numeroPortas;

    public Carro(){
        super();
    }

    public Carro(int codigo, String placa, String numeroChassi, String cor, int quilometragem, int numeroPortas){
        super(codigo, placa, numeroChassi, cor, quilometragem);
        this.numeroPortas = numeroPortas;
    }

}