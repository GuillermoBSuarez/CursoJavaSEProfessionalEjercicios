package view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import service.ManipulacionesService;

/* Interfaz PREDICATE: para definir el predicado hay que llamar al método funcional de la interfaz,
que es test, así que hay que crear una clase que la implemente. */
class CriterioPares implements Predicate<Integer> {
	@Override
	public boolean test(Integer t) {
		return t % 2 == 0;
	}
}

class CriterioNegativos implements Predicate<Integer> {
	@Override
	public boolean test(Integer t) {
		return t < 0;
	}
}

class CriterioLongitud implements Predicate<String>{
	@Override
	public boolean test(String t) {
		return t.length() > 5;
	}
}



// Interfaz CONSUMER: su método funcional es accept.
class guardarNegativos implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		try (	FileOutputStream fos = new FileOutputStream("c:\\temp\\negativos.txt", true);
				PrintStream ps = new PrintStream(fos)	) {
			ps.println(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}



public class OperaNumeros {
	public static void main(String[] args) {
		List<Integer> numeros = List.of(-5, 7, 11, 4, 2, -1, 10, 8);

		ManipulacionesService service = new ManipulacionesService();
		
		// Interfaz PREDICATE
		// Mostrar la suma de los pares:
		System.out.println("Suma pares: " + service.sumarCriterio(numeros, new CriterioPares()));
		// Mostrar la suma de los negativos:
		System.out.println("Suma negativos: " + service.sumarCriterio(numeros, new CriterioNegativos()));
		// Mostrar la lista de las cadenas más largas que 5:
		List<String> nombres = List.of("pan", "cadenalarga", "vino", "bicicleta");
		List<String> res = service.obtenerCadenasCriterio(nombres, new CriterioLongitud());
		System.out.println(res);
		
		// Interfaces PREDICATE y CONSUMER
		// Guardar en un fichero los negativos.
		service.procesaEnteros(numeros, new CriterioNegativos(), new guardarNegativos());
	}
}