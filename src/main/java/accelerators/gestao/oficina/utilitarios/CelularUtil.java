package accelerators.gestao.oficina.utilitarios;

//classe utilitaria a ser usada no servico de cliente
public class CelularUtil {
    public static String formatarCelular(String celular){ 
        if (celular == null || celular.length() != 11 || !celular.matches("\\d{11}")){
            throw new IllegalArgumentException("Celular inválido. Digite apenas números, sem caracteres especiais.");
        } 
        return celular.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3"); 
    }

    public static String removerFormatacao(String celular){
        if (celular == null){
            return null;
        } 
        return celular.replaceAll("[^\\d]", "");
    }
}
