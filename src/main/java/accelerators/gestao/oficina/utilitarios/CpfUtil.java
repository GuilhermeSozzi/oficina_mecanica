package accelerators.gestao.oficina.utilitarios;

//classe utilitaria a ser usada no servico de cliente
public class CpfUtil {
    //para quando for salvar os dados no BD
    public static String formatarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) { 
            throw new IllegalArgumentException("O CPF inserido é inválido. Digite apenas números, sem caracteres especiais."); 
        } 
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    //para quando for exibir no editar
    public static String removerFormatacao(String cpf){
        if (cpf == null){
            return null;
        } 
        return cpf.replaceAll("[^\\d]", "");
    }
}
