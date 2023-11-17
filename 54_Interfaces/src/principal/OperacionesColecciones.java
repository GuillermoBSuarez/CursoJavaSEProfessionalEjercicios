package principal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class OperacionesColecciones {

	public int suma(Collection<Number> lista) {
		int suma = 0;
		for (Number num : lista) {
			suma += num.intValue();
		}
		return suma;
	}

	public Set<Number> devolverComunes(Collection<Number> lista1, Collection<Number> lista2) {
		Set<Number> hs = new HashSet<>();
		/* Set es una interfaz, no se pueden instanciar objetos de tipo interfaz,
		sólo de un tipo de objeto que implemente la interfaz, como HashSet */

		for (Number n : lista1) {
			if (lista2.contains(n))
				hs.add(n);
		}
		return hs;
	}
}