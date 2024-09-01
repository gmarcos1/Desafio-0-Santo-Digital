import java.util.ArrayList;
import java.util.List;

public class Primeiraquestao {

    public static List<String> gerarListaAsteriscos(int n) {
        List<String> lista = new ArrayList<>(); // Inicializa a lista que vai armazenar as sequências

        // Itera de 1 até n para criar as sequências de asteriscos
        for (int i = 1; i <= n; i++) {
            StringBuilder asteriscos = new StringBuilder(); //Constroi a sequência de asteriscos usando StringBuilder

            // Adiciona 'i' asteriscos à sequência
            for (int j = 0; j < i; j++) {
                asteriscos.append("*");
            }

            lista.add(asteriscos.toString()); // Converte para string e adiciona à lista
        }

        return lista;
    }

    public static void main(String[] args) {
        int n = 5; // Define o número de linhas (ou quantidade máxima de asteriscos)
        List<String> resultado = gerarListaAsteriscos(n); // Gera a lista com as sequências
        System.out.println(resultado);
    }
}
