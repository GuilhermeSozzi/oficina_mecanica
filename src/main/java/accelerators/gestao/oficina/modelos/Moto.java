package accelerators.gestao.oficina.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("Moto")
public class Moto extends Veiculo {
    @Column(name = "vei_carroLateral", nullable = true)
    private String carroLateral;

    public Moto(){
        super();
    }

    public Moto(int codigo, String placa, String numeroChassi, String cor, int quilometragem, String carroLateral){
        super(codigo, placa, numeroChassi, cor, quilometragem);
        this.carroLateral = carroLateral;
    }
}
