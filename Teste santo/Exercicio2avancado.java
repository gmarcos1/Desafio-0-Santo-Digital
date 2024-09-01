import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exercicio2avancado {

    // Possui opções para permitir duplicados, ordenar os pares e garantir que os pares sejam únicos
    public static List<int[]> encontrarParesComMenorDiferenca(int[] array, boolean allowDuplicates, boolean sortedPairs, boolean uniquePairs) {
        Arrays.sort(array); // Ordena o array

        int menorDiferenca = Integer.MAX_VALUE; // Inicializa a menor diferença com o maior valor possível
        List<int[]> pares = new ArrayList<>(); // Lista para armazenar os pares encontrados
        Set<String> setParesUnicos = new HashSet<>(); // Conjunto para garantir a unicidade dos pares

        // Itera sobre todos os pares possíveis do array
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int diferenca = Math.abs(array[j] - array[i]); // Calcula a diferença entre dois elementos

                // Se duplicados não são permitidos e os elementos são iguais, ignora o par
                if (!allowDuplicates && array[i] == array[j]) {
                    continue;
                }

                // Se a diferença atual for menor que a menor diferença encontrada, atualiza os resultados
                if (diferenca < menorDiferenca) {
                    menorDiferenca = diferenca;
                    pares.clear(); // Limpa a lista de pares para adicionar o novo par de menor diferença
                    if (sortedPairs) {
                        pares.add(new int[]{Math.min(array[i], array[j]), Math.max(array[i], array[j])}); // Adiciona par ordenado
                    } else {
                        pares.add(new int[]{array[i], array[j]});
                    }
                    setParesUnicos.clear(); // Limpa o conjunto de pares únicos
                    setParesUnicos.add(array[i] + "," + array[j]); // Adiciona o par ao conjunto
                } else if (diferenca == menorDiferenca) {
                    // Cria o par e sua representação em string
                    int[] par = sortedPairs
                            ? new int[]{Math.min(array[i], array[j]), Math.max(array[i], array[j])}
                            : new int[]{array[i], array[j]};

                    String parString = par[0] + "," + par[1];
                    String parStringInverso = par[1] + "," + par[0];

                    // Se apenas pares únicos são permitidos e o par já foi adicionado, ignora
                    if (uniquePairs && (setParesUnicos.contains(parString) || setParesUnicos.contains(parStringInverso))) {
                        continue;
                    }

                    pares.add(par); // Adiciona o novo par à lista
                    setParesUnicos.add(parString); // Adiciona a string do par ao conjunto para garantir unicidade
                }
            }
        }

        return pares;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] array = new int[tamanho];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Permitir duplicados? (true/false): ");
        boolean allowDuplicates = scanner.nextBoolean();

        System.out.print("Ordenar pares? (true/false): ");
        boolean sortedPairs = scanner.nextBoolean();

        System.out.print("Apenas pares únicos? (true/false): ");
        boolean uniquePairs = scanner.nextBoolean();

        List<int[]> resultado = encontrarParesComMenorDiferenca(array, allowDuplicates, sortedPairs, uniquePairs);

        System.out.println("Pares com a menor diferença:");
        for (int[] par : resultado) {
            System.out.println(Arrays.toString(par));
        }

        scanner.close();
    }
}
