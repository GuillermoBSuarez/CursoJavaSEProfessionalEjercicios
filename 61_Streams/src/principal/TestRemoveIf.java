package principal;

import java.util.ArrayList;
import java.util.List;

public class TestRemoveIf {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>(List.of(7, 12, -9, 3, -6, 4));
		/* Una lista de List.of es INMUTABLE, pero un ArrayList no, así que creamos un ArrayList
		pasando como parámetro la lista y la guardamos en un objeto tipo List que, ahora sí, es mutable.
		También podríamos crear y guardar en un ArrayList, pero esto es para que se vean las características
		de unas y otras clases y cómo se transmiten. */
		
		numeros.removeIf(n -> n < 0);
		numeros.forEach(n -> System.out.println(n));
	}
}