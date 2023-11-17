package principal;

interface Calculadora {
	int sumar(int a, int b);
	int restar(int a, int b);
	int multiplicar(int a, int b);
	// Por defecto, los tres son public y abstract, no es necesario ponerlo.

	default int sumatorio(int... nums) {	// Default obligatorio;
		int resultado = 0;					// si no sería abstract y no podría tener cuerpo.
		for (int n : nums) {
			resultado += n;
		}
		return resultado;
	}
}

interface Estadisticas {
	default int sumatorio(int... datos) {
		return datos[0] + datos[datos.length - 1];
	}
}

class Matematicas implements Calculadora, Estadisticas {
	// Si implementa Calculadora debe sobreescribir los abstractos:
	@Override
	public int sumar(int a, int b) {
		return a + b;
	}

	@Override
	public int restar(int a, int b) {
		return Math.max(a, b) - Math.min(a, b);
	}

	@Override
	public int multiplicar(int a, int b) {
		return a * b;
	}
	
	/* En cambio, sobreescribir los métodos default es optativo... en principio. En este caso,
	ambas intefaces, Calculadora y Estadisticas, incorporan un método default sumatorio()
	con idénticos argumentos. En estos caso y desde Java 8 es obligatorio que la clase
	que incorpora ambos métodos lo sobreescriba, aunque... */
	@Override
	public int sumatorio(int... nums) {
		// ... se podría aprovechar uno así:
		return Calculadora.super.sumatorio(nums);
		// O return Estadisticas.super.sumatorio(nums);
	}
}

public class Test {
	public static void main(String[] args) {
		Matematicas mat = new Matematicas();
		System.out.println(mat.sumatorio(1, 2));
		System.out.println(mat.sumatorio(1, 2, 3, 4));
	}
}