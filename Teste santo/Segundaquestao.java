import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Segundaquestao {

    // Método que encontra todos os pares de elementos adjacentes no array com a menor diferença absoluta
    public static List<int[]> encontrarParesComMenorDiferenca(int[] array) {
        Arrays.sort(array); // Ordena o array para garantir que os elementos sejam comparados em ordem crescente

        int menorDiferenca = Integer.MAX_VALUE; // Inicializa a menor diferença com o maior valor possível
        List<int[]> pares = new ArrayList<>(); // Lista que vai armazenar os pares com a menor diferença encontrada

        // Itera sobre o array para encontrar pares com a menor diferença
        for (int i = 0; i < array.length - 1; i++) {
            int diferenca = Math.abs(array[i + 1] - array[i]); // Calcula a diferença entre elementos adjacentes

            //Verifica se diferença atual for menor que a menor diferença encontrada, atualiza a menor diferença e reseta a lista de pares
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                pares.clear();
                pares.add(new int[]{array[i], array[i + 1]});
            }
            // Se a diferença for igual à menor diferença encontrada, adiciona o par à lista
            else if (diferenca == menorDiferenca) {
                pares.add(new int[]{array[i], array[i + 1]});
            }
        }
        return pares;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3, 10}; // Array de exemplo
        List<int[]> resultado = encontrarParesComMenorDiferenca(array);

        // Exibe cada par encontrado
        for (int[] par : resultado) {
            System.out.println(Arrays.toString(par));
        }
    }
}
