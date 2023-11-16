package principal;

import java.util.ArrayList;

public class PruebaLista {

	public static void main(String[] args) {
		ArrayList<String> dias = new ArrayList<>();
		dias.add("Lunes");					// En dias[0]
		dias.add("Martes");					// En dias[1]
		dias.add(1, "Miércoles");			// En dias[1] y empuja a Martes a dias[2]
		System.out.println(dias.size());	// Size 3.
		System.out.println(dias.get(2));	// Martes
		dias.remove(0);						// Borra Lunes. dias[0] = "Miércoles" y dias[1] = "Martes"
		System.out.println(dias.get(2));	// Excepción, no existe, IndexOutOfBounds
	}
}