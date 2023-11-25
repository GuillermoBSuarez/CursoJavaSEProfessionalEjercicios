import java.util.stream.Stream;

public class Loteria {

	public static void main(String[] args) {
		Stream.generate( () -> (int) (Math.random() * 49 + 1) )	// Stream<Integer>
			  .distinct()										// Stream<Integer>
			  .limit(6)											// Stream<Integer>
			  .sorted()											// Stream<Integer>
			  .forEach(x -> System.out.print(x + " "));			// void
		
		/* La interfaz Stream								- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html
		tiene un método generate							- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html#generate(java.util.function.Supplier)
				generate(Supplier<? extends T> s)
		que incorpora una interfaz funcional Supplier		- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Supplier.html
		cuyo único método es el abstracto get(), que no recibe ningún parámetro y devuelve un stream
		infinito de valores del tipo especificado,
				static <T> Stream<T>
		en este caso ints aleatorios entre 1 y 49. */
	}
}