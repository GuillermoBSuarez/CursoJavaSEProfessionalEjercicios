package principal;

public class For_04 {
	public static void main(String[] args) {

		double[] temps = { 12.4, 23.3, 17.9, 30.1, 22.4, 17, 8 };
		double media = 0;
		int contador = 0;

		for (double t : temps) {
			media += t;
		}
		media /= temps.length;
		for (double t : temps) {
			if (t > media) {
				contador++;
			}
		}
		System.out.println("Temperatura media: " + media);
		System.out.println("Total de temperaturas superiores a la media: " + contador);
	}
}