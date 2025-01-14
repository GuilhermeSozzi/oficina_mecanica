package accelerators.gestao.oficina.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mod_codigo")
    private int codigo;
    @Column(name = "mod_nome", length = 20, nullable = false)
    private String nome;
    @Column(name = "mod_ano", nullable = false)
    private int ano;

    @ManyToOne
    @JoinColumn(name = "mar_codigo")
    private Marca marca;

    public Modelo(){
    }

    public Modelo(String nome, int ano, Marca marca) {
        this.nome = nome;
        this.ano = ano;
        this.marca = marca;
    }

}
