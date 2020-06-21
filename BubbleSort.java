import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int number[] = {1, 67, 2, 2, 4, 4, 12, 211, 3, 21421, 12, 365, 11, 2, 0, 9129, 21, 87, 2135, 27};
		
		// Output Array desordenado
		System.out.println(Arrays.toString(number));

		//Quantidade de entradas
		int n = number.length;
		
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (number[j + 1] > number[j]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
		
		// Output Array ordenado
		System.out.println(Arrays.toString(number));
		

	}

}