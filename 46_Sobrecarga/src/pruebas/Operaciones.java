package pruebas;

public class Operaciones {
	
	public Operaciones() {}							// Constructor por defecto.
	
	public int sum (String s, int ... numeros) {		
		int suma = 0;
		for (int n:numeros) {
			suma += n;
		}
		return suma;
	}
		
	/* Preferencia en la sobrecarga de métodos: con una llamada operaciones.suma(5),
	el orden en que entrará en un método es: */
	public int sum(int x) { return x; }		// 1. coincidencia exacta
	public int sum(long x) { return 0; }	// 2. promoción de tipos
	public int sum(Integer x) { return x; }	// 3. autoboxing
	public int sum(int...x) { return 0; }	// 4. número variable de argumentos
	
	/*
	public int division(int...x) {}
	public int division(int[] x) {}
	Error de compilación. Para Java es lo mismo un array que un número variable de argumentos,
	por tanto los lee como el mismo método. */
}
