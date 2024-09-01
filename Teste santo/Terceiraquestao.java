import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terceiraquestao {

    // Método que gera todos os subconjuntos possíveis de um array de inteiros
    public static List<List<Integer>> gerarSubconjuntos(int[] nums) {
        List<List<Integer>> subconjuntos = new ArrayList<>(); // Lista que vai armazenar todos os subconjuntos
        subconjuntos.add(new ArrayList<>()); // Adicionando o subconjunto vazio

        // Itera sobre cada número do array
        for (int num : nums) {
            int n = subconjuntos.size(); // Tamanho atual da lista de subconjuntos

            // Para cada subconjunto existente vai criar um novo subconjunto que inclui o número atual
            for (int i = 0; i < n; i++) {
                List<Integer> subconjunto = new ArrayList<>(subconjuntos.get(i)); // Copia o subconjunto existente
                subconjunto.add(num); // Adiciona o número atual ao subconjunto
                subconjuntos.add(subconjunto); // Adiciona o novo subconjunto à lista de subconjuntos
            }
        }

        return subconjuntos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] nums = new int[tamanho]; // Cria o array com o tamanho informado

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            nums[i] = scanner.nextInt();
        }

        List<List<Integer>> resultado = gerarSubconjuntos(nums); // Gera todos os subconjuntos do array

        System.out.println("Subconjuntos gerados:");
        for (List<Integer> subconjunto : resultado) {
            System.out.println(subconjunto);
        }

        scanner.close();
    }
}
