import java.util.Arrays;
import java.util.List;

public class Test3Filter {

	public static void main(String[] args) {
		List<Integer> nums = List.of(6, 11, -4, 8, -1, 10, 8, 2, 11, 27, -5, -4, 41, 10);

		// ¿Cuántos pares distintos hay?
		System.out.println(
				nums.stream()
				.distinct()
				.filter(n -> n%2==0)
				.count()
		);
		
		String nombres = "leche, atun, vino, patatas, leche, agua, vino, lechuga";
		
		// ¿Cuántos productos de menos de 6 caracteres hay?
		System.out.println(
				Arrays.stream(nombres.split(", "))
				.distinct()
				.filter(n -> n.length()<6)
				.count()
		);
	}
}