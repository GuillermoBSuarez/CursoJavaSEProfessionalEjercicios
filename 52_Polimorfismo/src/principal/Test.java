package principal;

public class Test {

	public static void main(String[] args) {
		Object ob = "cadena";
		
		// String cad = ob;			// Incorrecto, ob es una referencia, no puede convertirse sin más.
		
		String cad = (String) ob;	/* Correcto, el cast se puede hacer siempre
									de variable del tipo padre (ob) al tipo hijo (cad) */
		
		System.out.print(cad.getClass().getSimpleName());
	}
}