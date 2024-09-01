import java.util.ArrayList;
import java.util.List;

public class Primeiraquestao{
    public static List<String> gerarListaAsteriscos(int n) {
        List<String> lista = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder asteriscos = new StringBuilder();
            for (int j = 0; j < i; j++) {
                asteriscos.append("*");
            }
            lista.add(asteriscos.toString());
        }
        return lista;
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> resultado = gerarListaAsteriscos(n);
        System.out.println(resultado);
    }
}
