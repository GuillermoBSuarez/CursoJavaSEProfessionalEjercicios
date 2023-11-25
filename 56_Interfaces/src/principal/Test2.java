package principal;

import java.util.List;

class Datos2 {
	// método que devuelve una lista con los 10 primeros números enteros.
	// Antes crearíamos un ArrayList y un for de 1 a 10 que vaya añadiendo
	// elementos al ArrayList. Ahora...
	public List<Integer> numeros () {
		return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		/* List es una interfaz que ahora incorporan métodos estáticos, como of()
		   que crean (devuelven) implementaciones de esa interfaz, del mismo tipo (List).
		   Ojo: los objetos que devuelven estos métodos estáticos son INMUTABLES. */
	}
}

public class Test2 {

	public static void main(String[] args) {
		Datos2 dt = new Datos2();
		List<Integer> nums = dt.numeros();
		for (Integer n:nums) {
			System.out.println(n);
		}
	}
}