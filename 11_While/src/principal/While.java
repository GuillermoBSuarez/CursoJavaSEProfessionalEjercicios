package principal;

public class While {

	public static void main(String[] args) {

		// Empezando por 1, ¿cuántos números hay que sumar hasta alcanzar o superar 1000?
		
		int totalNumeros = 0;
		int suma = 0;
		
		while (suma < 1000) {
			totalNumeros++;
			suma += totalNumeros;
			System.out.println(totalNumeros + " - " + suma);
		}
		
		System.out.println("Suma total: " + suma);
		System.out.println("Total números: " + totalNumeros);
	}
}