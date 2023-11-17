package principal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestForEach {

	public static void main(String[] args) {
		List<Integer> numeros = List.of(6, 9, 3, 4);

		// Método tradicional de recorrer la lista.
		for (Integer n : numeros) {
			System.out.println(n);
		}

		// Método nuevo con programación funcional.
		numeros.forEach(n -> System.out.println(n));

		/* Recuperamos el ejercicio 28_HashMap porque con programación funcional y forEach
		sí se puede recorrer un HashMap. */
		Map<Integer, String> dias = new HashMap<>();
		dias.put(125, "lunes");
		dias.put(300, "martes");
		dias.put(400, "miércoles");
		dias.put(200, "jueves");
		dias.forEach((k, v) -> System.out.println(k + ", " + v));
	}
}