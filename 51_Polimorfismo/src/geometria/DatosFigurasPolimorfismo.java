package geometria;

public class DatosFigurasPolimorfismo {

	private Number n;
	
	public static void main(String[] args) {
		mostrarDatos(new Triangulo("amarillo", 6, 9));
		mostrarDatos(new Circulo("azul", 7));
	}

	static void mostrarDatos(Figura fr)
	{
		System.out.println("Color del " + fr.getClass().getSimpleName() + ": " + fr.getColor());
		System.out.println("Superficie del " + fr.getClass().getSimpleName() + ": " + fr.calcularArea());
	}
}