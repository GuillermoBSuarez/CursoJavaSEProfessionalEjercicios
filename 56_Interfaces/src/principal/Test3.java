package principal;

interface Printer {
	void print(String cad);
	
	static Printer of() {
		// Crear un objeto que implemente la interfaz mediante una clase ANÓNIMA
		return new Printer() {
			@Override
			public void print(String cad) {
				System.out.println(cad);
			}
		};
	}
}

public class Test3 {

	public static void main(String[] args) {
		Printer pr = Printer.of();
		// El método estático of() de la interfaz devuelve un new (una implementación)
		// de un objeto Printer.
		// Sin implementar la interfaz, sin crear una clase que la implemente.
	}
}
