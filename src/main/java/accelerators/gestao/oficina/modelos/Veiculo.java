package accelerators.gestao.oficina.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "veiculo")
@DiscriminatorColumn(name = "vei_tipo", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vei_codigo")
    private int codigo;

    @Column(name = "vei_placa", nullable = false, unique = true, length = 7)
    private String placa;

    @Column(name = "vei_chassi", nullable = false, unique = true, length = 17)
    private String numeroChassi;

    @Column(name = "vei_cor", nullable = false, length = 20)
    private String cor;

    @Column(name = "vei_quilometragem", nullable = false)
    private int quilometragem;

    @ManyToOne
    @JoinColumn(name = "mod_codigo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "cli_codigo")
    private Cliente cliente;

    public Veiculo(){
    }

    public Veiculo(int codigo, String placa, String numeroChassi, String cor, int quilometragem) {
        this.codigo = codigo;
        this.placa = placa;
        this.numeroChassi = numeroChassi;
        this.cor = cor;
        this.quilometragem = quilometragem;
    }

}
