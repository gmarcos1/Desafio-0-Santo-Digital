import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Segundaquestao {
    public static List<int[]> encontrarParesComMenorDiferenca(int[] array) {
        Arrays.sort(array);
        
        int menorDiferenca = Integer.MAX_VALUE;
        List<int[]> pares = new ArrayList<>();
        
        for (int i = 0; i < array.length - 1; i++) {
            int diferenca = Math.abs(array[i + 1] - array[i]);
            
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                pares.clear();
                pares.add(new int[]{array[i], array[i + 1]});
            } else if (diferenca == menorDiferenca) {
                pares.add(new int[]{array[i], array[i + 1]});
            }
        }
        
        return pares;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3, 10};
        List<int[]> resultado = encontrarParesComMenorDiferenca(array);
        
        for (int[] par : resultado) {
            System.out.println(Arrays.toString(par));
        }
    }
}
