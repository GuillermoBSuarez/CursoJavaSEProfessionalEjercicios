package principal;

import java.util.HashSet;

public class Loteria {

	public static void main(String[] args) {
		HashSet<Integer> apuesta = new HashSet<>();
		
		while (apuesta.size() < 6) {
			apuesta.add( (int) (Math.random()*49+1));	// Ya no hay que comprobar si el número ya está en la colección
		}												// porque HashSet no admite duplicados.
		
		for (Integer n:apuesta) {
			System.out.print(n + ", ");
		}
	}
}