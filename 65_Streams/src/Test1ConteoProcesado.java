import java.util.List;

public class Test1ConteoProcesado {

	public static void main(String[] args) {
		List<Integer> nums = List.of(6, 11, -4, 8, -1, 10, 8, 2, 11, 27, -5, -4, 41, 10);

		// MÉTODOS FINALES
		// count()
		System.out.println(nums.stream().count());
		// forEach() - que recibe un consumer y, por tanto, no devuelve nada.
		nums.stream().forEach(x -> System.out.print(x + " - "));
		System.out.println();

		// MÉTODOS INTERMEDIOS
		// distinct()
		nums.stream().distinct().forEach(x -> System.out.print(x + " - "));
		System.out.println();
		// limit(long n) - devuelve n elementos
		nums.stream().limit(5).forEach(x -> System.out.print(x + " - "));
		System.out.println();
		// skip(long n) - devuelve todos exceptuando los n primeros
		nums.stream().skip(5).forEach(x -> System.out.print(x + " - "));
		System.out.println();

		// Ejemplo: devolver los 7 primeros no repetidos
		nums.stream().distinct().limit(7).forEach(x -> System.out.print(x + " - "));
		System.out.println();
	}
}