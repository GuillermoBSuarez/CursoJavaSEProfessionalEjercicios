package principal;

import java.util.ArrayList;
import java.util.List;

public class TestSort {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>(List.of(7, 12, -9, 3, -6, 4));
		
		// numeros.sort((a, b) -> a>b? 1:-1);
		// 		Una forma de que haga una cosa u otra según un número u otro sea mayor
		
		numeros.sort((a, b) -> a - b);
		/* Método sort de List<E>:
		https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#sort(java.util.Comparator)
		Interfaz Comparator:
		https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html
		La interfaz tiene el método abstracto compare(T o1, T o2):
		https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html#compare(T,T)
		que devuelve un Integer negativo, cero o positivo si el primer argumento es menor, igual o mayor que el segundo.
		De ahí el restarlos. */
		numeros.forEach(n -> System.out.println(n));
		
		List<String> cadenas = new ArrayList<>(List.of("Marcos", "Lucas", "Laura", "Angela", "Elena"));
		cadenas.sort((a, b) -> a.compareToIgnoreCase(b));		// o compareTo solo si nos la sudan las mayúsculas y minúsculas
		cadenas.forEach(n -> System.out.println(n));
	}
}