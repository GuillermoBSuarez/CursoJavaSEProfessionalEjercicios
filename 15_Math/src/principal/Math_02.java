package principal;

import java.util.Arrays;

public class Math_02 {

	public static void main(String[] args) {
		int[] apuesta = new int[6];
		int nums = 0;

		while (nums < 6) {
			int num = (int) (Math.random() * 49 + 1);
			if (!repetido(apuesta, num, nums)) {	// Devuelve si num ya está en la apuesta. Si no lo está...
				apuesta[nums] = num;				// ... lo añade
				nums++;								// y actualiza el contador de números en la apuesta.
			}
		}
		
		ordenar(apuesta); // = Arrays.sort(apuesta); -
						  // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html
		mostrar(apuesta);
	}

	private static void mostrar(int[] apuesta) {
		/* El apuesta de este método, al ser un array (objeto, no primitivo) sólo copia
		   la dirección de memoria de apuesta, no el valor. Por tanto, las modificaciones
		   que se hacen en el método afectan al único apuesta que realmente existe.
		   Por eso no es necesario que el método retorne el array modificado. */
		for (int x = 0; x < apuesta.length; x++) {
			System.out.print(apuesta[x] + " ");
		}
	}

	private static void ordenar(int[] apuesta) {
		int aux;
		for (int x = 0; x < apuesta.length; x++) {
			for (int y = x + 1; y < apuesta.length; y++) {
				if (apuesta[y] < apuesta[x]) {
					aux = apuesta[y];
					apuesta[y] = apuesta[x];
					apuesta[x] = aux;
				}
			}
		}
	}

	private static boolean repetido(int[] apuesta, int num, int nums) {
		for (int i = 0; i < nums; i++) {
			if (apuesta[i] == num) {
				return true;
			}
		}
		return false;
	}
}