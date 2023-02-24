import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Calculos {

    public static void main(String[] args) {
        
        // Pedimos al usuario que ingrese el tamaño del arreglo
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite el tamaño que tendra el arreglo: ");
        int n = sc.nextInt();
        
        // Llenamos el arreglo con números aleatorios entre 0 y 100
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(101);
        }
        System.out.println("El Arreglo aleatorio es: " + Arrays.toString(arr));
        
        // Calculamos la media
        double media = 0;
        for (int i = 0; i < n; i++) {
            media += arr[i];
        }
        media /= n;
        System.out.println("La Media es: " + media);
        
        // Calculamos la mediana
        Arrays.sort(arr);
        double mediana = 0;
        if (n % 2 == 0) {
            mediana = (arr[n/2] + arr[n/2 - 1]) / 2.0;
        } else {
            mediana = arr[n/2];
        }
        System.out.println("La Mediana es: " + mediana);
        
        // Calculamos la varianza
        double varianza = 0;
        for (int i = 0; i < n; i++) {
            varianza += Math.pow(arr[i] - media, 2);
        }
        varianza /= n;
        System.out.println("La Varianza es: " + varianza);
        
        // Calculamos la desviación estándar
        double desviacion = Math.sqrt(varianza);
        System.out.println("La Desviación estándar es: " + desviacion);
        
        // Calculamos la moda
        int moda = arr[0];
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    moda = arr[i-1];
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            moda = arr[n-1];
            System.out.print("La Moda es: " + moda);
        }
    }
}