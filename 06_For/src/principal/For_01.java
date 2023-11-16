package principal;

public class For_01 {

	public static void main(String[] args) {
		// Mostrar la suma de todos los números pares entre 1 y 20

		int total = 0;

		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				total += i;
				if (i < 20) {
					System.out.println("Total parcial: " + total);
				}
			}
		}
		System.out.println("Total final: " + total);
	}
}