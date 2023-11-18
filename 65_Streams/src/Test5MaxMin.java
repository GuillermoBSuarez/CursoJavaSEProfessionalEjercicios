import java.util.List;

public class Test5MaxMin {

	public static void main(String[] args) {
		List<Integer> nums = List.of(6, 11, -4, 8, -1, 10, 8, 2, 11, 27, -5, -4, 41, 10);

		// Mostrar el negativo más alto
		System.out.println(nums.stream().filter(c -> c < 0).max((a, b) -> a - b).orElse(null));
	}
}