package principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		ArrayList<Number> listaA = new ArrayList<>();
		listaA.add(1);
		listaA.add(2);
		listaA.add(3);
		listaA.add(5);

		HashSet<Number> conjuntoH = new HashSet<>();
		conjuntoH.add(4);
		conjuntoH.add(5);
		conjuntoH.add(6);

		OperacionesColecciones oc = new OperacionesColecciones();

		System.out.println(oc.suma(listaA));
		System.out.println(oc.suma(conjuntoH));

		Set<Number> resultado = oc.devolverComunes(listaA, conjuntoH);
		for (Number i : resultado) {
			System.out.println(i);
		}
	}
}