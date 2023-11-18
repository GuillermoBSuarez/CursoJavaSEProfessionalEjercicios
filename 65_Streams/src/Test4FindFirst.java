import java.util.Arrays;
import java.util.List;

public class Test4FindFirst {

	public static void main(String[] args) {
		List<Integer> nums = List.of(6, 11, -4, 8, -1, 10, 8, 2, 11, 27, -5, -4, 41, 10);

		// ¿Cuál es el primer negativo?
		System.out.println(nums.stream()
				.distinct()
				.filter(n -> n < 0)
				.findFirst()	// Devuelve un objeto Optional de un entero, o sea: Optional[-4].
				.get()			// Devuelve un entero: -4.
		/* No se recomienda usar get() porque puede que tras el filtro no haya
		ningún valor que mostrar, con lo que lanzará una excepción. */
		);

		String nombres = "leche, atun, vino, patatas, leche, agua, vino, lechuga";
		// Nombre del primer producto que empiece por A, o mensaje informando de que no hay.
		System.out.println(Arrays.stream(nombres.split(", "))
				.distinct()
				.filter(n -> n.startsWith("a"))
				.findFirst()
				.orElse("No hay ninguno")		/* Alternativa a get(): orElse(P). También desencapsula
				pero se le pasa un parámetro que usar si no encuentra ningún valor Y QUE DEBE SER
				DEL MISMO TIPO QUE EL MÉTODO NECESITA, en este caso, un String para println,
				pero si es en una función, orElse debe devolver lo mismo que devuelve la función:
				string, boolean, objeto, etc. */
		);
	}
}