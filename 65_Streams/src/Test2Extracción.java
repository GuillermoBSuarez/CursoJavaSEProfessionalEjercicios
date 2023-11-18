import java.util.List;

public class Test2Extracción {

	public static void main(String[] args) {
		List<Integer> nums = List.of(6, 11, -4, 8, -1, 10, 8, 2, 11, 27, -5, -4, 41, 10);

		// Devolver los 7 primeros no repetidos
		nums.stream().distinct().limit(7).forEach(x -> System.out.print(x + " - "));
		System.out.println();

		// ¿Hay algún negativo?
		System.out.println(nums.stream().anyMatch(x -> x < 0));

		// ¿Son todos pares?
		System.out.println(nums.stream().allMatch(x -> x % 2 == 0));

		/* Ojo al resultado: 6, 11 y -4. Porque estos métodos trabajan en modo cortocircuito,
		así que en cuento encuentra el primer negativo (-4) termina. */
		nums.stream().anyMatch(x -> {
			System.out.println(x);
			return x < 0;
		});
	}
}