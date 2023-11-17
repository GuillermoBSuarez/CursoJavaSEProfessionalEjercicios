package principal;

import clases.Mesa;
import clases.Punto3D;
import interfaces.Operaciones;

public class TestPolimorfismo {

	public static void main(String[] args) {
		procesar (new Mesa(30, 2, 4));
		procesar (new Punto3D(5, 3, 2));
	}

	public static void procesar (Operaciones oper) {
		oper.girar(30);
		System.out.println(oper.invertir());
	}
}