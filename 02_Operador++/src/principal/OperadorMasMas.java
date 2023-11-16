package principal;

public class OperadorMasMas {

	public static void main(String[] args) {

		int a = 1;
		if (a++ == 1) {								// Primero compara, a todavía vale 1, así que entra en if. Luego incrementa.
			System.out.println("Línea 9: " + a);	// a = 2.
			++a;									// a = 3.
			System.out.println("Línea 11: " + a);	// a = 3
		}
		System.out.println("Línea 13: " + ++a);		// Incrementa a y luego imprime. a = 4.
		System.out.println("Línea 14: " + a);		// a = 4.
	}
}