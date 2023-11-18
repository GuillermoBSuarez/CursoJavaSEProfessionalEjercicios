import java.util.List;

public class Test6Ordenación {

	public static void main(String[] args) {
		List<Integer> nums = List.of(6, 11, -4, 8, -1, 10, 8, 2, 11, 27, -5, -4, 41, 10);
		
		// ¿Cuál es el más pequeño?
		System.out.println(nums.stream()
							   .sorted()		// Sorted sin Comparator hace una ordenación natural.
							   .findFirst()
							   .get());
		
		// Mostrar los cinco números mayores sin repeticiones
		nums.stream()
			.distinct()
			.sorted( (a, b) -> b - a )
				// para ordenar inversamente sí hace falta un Comparator
			.limit(5)
			.forEach ( n -> System.out.print(n + " - "));
		/* Se imprime al final, cada número, porque si lo hacemos hasta el limit y lo metemos todo
		en una orden de imprimir lo que imprimirá será lo que devuelve limit, que es un objeto Stream,
		por lo que imprimirá una referencia a la zona de memoria donde está dicho objeto. */
	}
}