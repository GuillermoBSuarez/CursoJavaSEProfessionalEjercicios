package principal;

public class Arrays_02 {

	public static void main(String[] args) {

		// Ejemplo con edades:

		double total = 0;
		int[] edades = { 34, 19, 28, 55, 61, 40 };
		int mayor = edades[0], menor = edades[0];

		for (int i = 0; i < edades.length; i++) {
			total += edades[i];
			if (edades[i] > mayor) {
				mayor = edades[i];
			}
			if (edades[i] < menor) {
				menor = edades[i];
			}
		}
		System.out.println("Media: " + total / edades.length);
		System.out.println("El mayor tiene " + mayor + " años.");
		System.out.println("El menor tiene " + menor + " años.");

		// Ejemplo con temperaturas:
		// ¿Cuántas ciudades tienen una temperatura superior a la media?

		double[] temps = { 12.4, 23.3, 17.9, 30.1, 22.4, 17, 8 };
		double tempTotal = 0;
		int ciudadesPorEncima = 0;

		for (int i = 0; i < temps.length; i++) {
			tempTotal += temps[i];
		}
		double tempMedia = tempTotal / temps.length;
		for (int i = 0; i < temps.length; i++) {
			if (temps[i] > tempMedia) {
				ciudadesPorEncima++;
			}
		}
		System.out.println("Total de ciudades: " + temps.length);
		System.out.println("Temperatura media: " + tempMedia);
		System.out.println("Total de ciudades por encima de la media: " + ciudadesPorEncima);
	}
}