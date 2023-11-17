package geometria;

public class DatosFiguras {

	public static void main(String[] args) {
		
		Triangulo tr = new Triangulo("amarillo", 6, 9);
		System.out.println("Color: " + tr.getColor());
		System.out.println("Superficie: " + tr.calcularArea());
		
		Circulo cr = new Circulo("azul", 7);
		System.out.println("Color: " + cr.getColor());
		System.out.println("Superficie: " + cr.calcularArea());
	}
}