import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercicio3avancado{
    public static List<List<Integer>> generateSubsets(int[] array, Integer maxSize, Integer minSize, boolean distinctOnly, boolean sortSubsets) {

        if (sortSubsets) {
            Arrays.sort(array);
        }

        List<List<Integer>> subsets = new ArrayList<>();

        generateSubsetsHelper(array, 0, new ArrayList<>(), subsets, maxSize, minSize, distinctOnly, new HashSet<>());

        if (sortSubsets) {
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

        return subsets;
    }

    private static void generateSubsetsHelper(int[] array, int index, List<Integer> currentSubset, List<List<Integer>> subsets, Integer maxSize, Integer minSize, boolean distinctOnly, Set<String> distinctSet) {

        if ((minSize == null || currentSubset.size() >= minSize) && (maxSize == null || currentSubset.size() <= maxSize)) {
            if (!distinctOnly || distinctSet.add(currentSubset.toString())) {
                subsets.add(new ArrayList<>(currentSubset));
            }
        }

        for (int i = index; i < array.length; i++) {
            currentSubset.add(array[i]);
            generateSubsetsHelper(array, i + 1, currentSubset, subsets, maxSize, minSize, distinctOnly, distinctSet);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2};
        Integer maxSize = 2;
        Integer minSize = 1; 
        boolean distinctOnly = true; 
        boolean sortSubsets = true;

        List<List<Integer>> subsets = generateSubsets(array, maxSize, minSize, distinctOnly, sortSubsets);

        System.out.println("Subconjuntos:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
