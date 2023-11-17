package principal;

interface Datos {
	static void print() {
		System.out.println("Interfaz Datos");
	}
}

class Prueba implements Datos {
	/* Con sólo crear la clase no aparece ningún mensaje de error obligando a sobrescribir nada,
	porque el método print de la interfaz es static, por tanto invisible para la clase.
	Sólo se le puede llamar desde aquí con Datos.print() desde el main.
	
	Pero la clase podría tener su propio método print: */
	static void print() {
		System.out.println("Clase Prueba");
	}
}

public class Test {
	public static void main(String[] args) {
		Datos.print();	// print de la interfaz, invisible para Prueba por ser static.
		Prueba.print(); // print de la clase.
	}
}