/* Viene del 58_InterfacesFuncionales.
Ya no creamos clases que implementan las interfaces funcionales ni creamos objetos de dichas clases
en el mail, sino que lo adaptamos a expresiones lambda. */

package view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import service.ManipulacionesService;

public class OperaNumeros {
	public static void main(String[] args) {
		List<Integer> numeros = List.of(-5, 7, 11, 4, 2, -1, 10, 8);

		ManipulacionesService service = new ManipulacionesService();
		
		// Interfaz PREDICATE
		// Mostrar la suma de los pares:
		System.out.println("Suma pares: " + service.sumarCriterio(numeros, t -> t % 2 == 0));
		// Mostrar la suma de los negativos:
		System.out.println("Suma negativos: " + service.sumarCriterio(numeros, t -> t < 0));
		
		/* SumarCriterio sigue recibiendo una List de números y un parámetro para una función lambda.
		En la definición de SumarCriterio, ese parámetro es el Integer que se envía al objeto Predicate. */
		
		// Mostrar la lista de las cadenas más largas que 5:
		List<String> nombres = List.of("pan", "cadenalarga", "vino", "bicicleta");
		List<String> res = service.obtenerCadenasCriterio(nombres, t -> t.length() > 5);
		System.out.println(res);

		// Interfaces PREDICATE y CONSUMER
		// Guardar en un fichero los negativos.
		service.procesaEnteros(numeros, t -> t < 0, t -> {
			try (	FileOutputStream fos = new FileOutputStream("c:\\temp\\negativos.txt", true);
					PrintStream ps = new PrintStream(fos)	) {
				ps.println(t);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}