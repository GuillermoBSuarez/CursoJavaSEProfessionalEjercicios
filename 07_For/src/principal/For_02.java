package principal;

public class For_02 {

	public static void main(String[] args) {

		// Calcular la suma de los números comprendidos entre
		int a = 30, b = 5;

		int menor = 0, mayor = 0, suma = 0;

		if (a < b) {
			menor = a;
			mayor = b;
		} else {
			menor = b;
			mayor = a;
		}

		for (int i = menor; i <= mayor; i++) {
			suma += i;
			System.out.println("i: " + i + ". Suma: " + suma);
		}

		System.out.println("Total: " + suma);
	}
}