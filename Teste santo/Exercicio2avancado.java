import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exercicio2avancado {
    public static List<int[]> encontrarParesComMenorDiferenca(int[] array, boolean allowDuplicates, boolean sortedPairs, boolean uniquePairs) {
        Arrays.sort(array);

        int menorDiferenca = Integer.MAX_VALUE;
        List<int[]> pares = new ArrayList<>();
        Set<String> setParesUnicos = new HashSet<>();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int diferenca = Math.abs(array[j] - array[i]);
                if (!allowDuplicates && array[i] == array[j]) {
                    continue;
                }

                if (diferenca < menorDiferenca) {
                    menorDiferenca = diferenca;
                    pares.clear();
                    if (sortedPairs) {
                        pares.add(new int[]{Math.min(array[i], array[j]), Math.max(array[i], array[j])});
                    } else {
                        pares.add(new int[]{array[i], array[j]});
                    }
                    setParesUnicos.clear();
                    setParesUnicos.add(array[i] + "," + array[j]);
                } else if (diferenca == menorDiferenca) {
                    int[] par = sortedPairs
                            ? new int[]{Math.min(array[i], array[j]), Math.max(array[i], array[j])}
                            : new int[]{array[i], array[j]};
                    
                    String parString = par[0] + "," + par[1];
                    String parStringInverso = par[1] + "," + par[0];

                    if (uniquePairs && (setParesUnicos.contains(parString) || setParesUnicos.contains(parStringInverso))) {
                        continue;
                    }

                    pares.add(par);
                    setParesUnicos.add(parString);
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
