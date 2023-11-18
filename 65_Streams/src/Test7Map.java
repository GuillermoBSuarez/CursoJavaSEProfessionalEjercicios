import java.util.Arrays;
import java.util.List;

public class Test7Map {

	public static void main(String[] args) {
		String nombres = "leche,atun,vino,patatas,mantequilla,ajo,arroz,lechuga";
		List<Integer> nums = List.of(6, 11, -4, 8, -1, 10, 8, 2, 11, 27, -5, -4, 41, 10);

		// Mostrar las longitudes de cada texto de menor a mayor
		Arrays.stream(nombres				// Stream<String>
				.split(","))				// Array<String>
				.map( s -> s.length() )		// Stream<Integer>
				.sorted()					// Stream<Integer>
				.forEach( n -> System.out.print(n + ", "));	
		
		// Total de caracteres de todos los productos sin contar repetidos
		System.out.println();
		System.out.println(Arrays.stream(nombres	// Stream<String>
				.split(","))						// Array<String>
				.distinct()							// Stream<String>
				.mapToInt( s -> s.length() )		// IntStream
				.sum());							// Integer
		
		// Calcular la media de todos los positivos
		System.out.println(nums.stream()		// Strea<Integer>
				.filter( n -> n>0 )				// Stream<Integer>, que no tiene el método average()
				.mapToInt( n -> n )				// IntStream, que sí tiene average(), por eso la transformación
				.average()						// OptionalDouble
				.orElse(0));					// double				
	}
}