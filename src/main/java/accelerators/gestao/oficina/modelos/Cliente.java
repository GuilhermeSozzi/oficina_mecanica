package accelerators.gestao.oficina.modelos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_codigo")
    private int codigo;
    @Column(name = "cli_nome", nullable = false, length = 60)
    private String nome;
    @Column(name = "cli_cpf",nullable = false, length = 14, unique = true)
    private String cpf;
    @Column(name = "cli_email", nullable = false, length = 50)
    private String email;
    @Column(name = "cli_celular", nullable = false, length = 15, unique = true)
    private String celular;
    @Column(name = "cli_rua", nullable = false, length = 30)
    private String rua;
    @Column(name = "cli_numero", nullable = false)
    private int numero;
    @Column(name = "cli_bairro", nullable = false, length = 30)
    private String bairro;
    @Column(name = "cli_cidade", nullable = false, length = 30)
    private String cidade;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Veiculo> veiculos = new HashSet<>();

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String cpf, String email, String celular, String rua, int numero,
            String bairro, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

}
