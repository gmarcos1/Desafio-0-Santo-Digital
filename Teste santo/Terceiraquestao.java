import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terceiraquestao {
    public static List<List<Integer>> gerarSubconjuntos(int[] nums) {
        List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>());

        for (int num : nums) {
            int n = subconjuntos.size();
            for (int i = 0; i < n; i++) {
                List<Integer> subconjunto = new ArrayList<>(subconjuntos.get(i));
                subconjunto.add(num);
                subconjuntos.add(subconjunto);
            }
        }

        return subconjuntos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do usuário para o array
        System.out.print("Informe o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] nums = new int[tamanho];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            nums[i] = scanner.nextInt();
        }

        List<List<Integer>> resultado = gerarSubconjuntos(nums);

        System.out.println("Subconjuntos gerados:");
        for (List<Integer> subconjunto : resultado) {
            System.out.println(subconjunto);
        }
        
        scanner.close();
    }
}
