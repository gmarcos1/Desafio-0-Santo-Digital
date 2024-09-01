import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercicio3avancado {

    // Método que gera subconjuntos de um array de inteiros com opções de filtragem e ordenação
    public static List<List<Integer>> generateSubsets(int[] array, Integer maxSize, Integer minSize, boolean distinctOnly, boolean sortSubsets) {

        if (sortSubsets) {
            Arrays.sort(array); // Ordena o array se solicitado
        }

        List<List<Integer>> subsets = new ArrayList<>(); // Lista para armazenar os subconjuntos gerados

        // Chama o método auxiliar para gerar subconjuntos
        generateSubsetsHelper(array, 0, new ArrayList<>(), subsets, maxSize, minSize, distinctOnly, new HashSet<>());

        if (sortSubsets) {
            // Ordena os subconjuntos gerados primeiro por tamanho e depois lexicograficamente
            subsets.sort((o1, o2) -> {
                if (o1.size() != o2.size()) {
                    return Integer.compare(o1.size(), o2.size());
                }
                for (int i = 0; i < o1.size(); i++) {
                    int cmp = Integer.compare(o1.get(i), o2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            });
        }

        return subsets; // Retorna a lista de subconjuntos gerados
    }

    // Método auxiliar para gerar subconjuntos recursivamente
    private static void generateSubsetsHelper(int[] array, int index, List<Integer> currentSubset, List<List<Integer>> subsets, Integer maxSize, Integer minSize, boolean distinctOnly, Set<String> distinctSet) {

        // Verifica se o subconjunto atual atende aos critérios de tamanho e se deve ser adicionado à lista
        if ((minSize == null || currentSubset.size() >= minSize) && (maxSize == null || currentSubset.size() <= maxSize)) {
            if (!distinctOnly || distinctSet.add(currentSubset.toString())) {
                subsets.add(new ArrayList<>(currentSubset)); // Adiciona uma cópia do subconjunto atual
            }
        }

        // Itera para adicionar elementos ao subconjunto atual e chama recursivamente o método para gerar novos subconjuntos
        for (int i = index; i < array.length; i++) {
            currentSubset.add(array[i]); // Adiciona o elemento atual ao subconjunto
            generateSubsetsHelper(array, i + 1, currentSubset, subsets, maxSize, minSize, distinctOnly, distinctSet); // Chamada recursiva
            currentSubset.remove(currentSubset.size() - 1); // Remove o último elemento para explorar outras combinações
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2}; // Array de exemplo
        Integer maxSize = 2;
        Integer minSize = 1;
        boolean distinctOnly = true; // Filtra apenas subconjuntos distintos
        boolean sortSubsets = true; // Ordena os subconjuntos

        List<List<Integer>> subsets = generateSubsets(array, maxSize, minSize, distinctOnly, sortSubsets); // Gera os subconjuntos com os parâmetros especificados

        System.out.println("Subconjuntos:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
