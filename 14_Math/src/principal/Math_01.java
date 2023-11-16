package principal;

public class Math_01 {

	public static void main(String[] args) {

		// Comprobar la aleatoriedad de random en 10 millones de tiradas de un dado.

		int tirada = 0;
		int[] totalesCara = new int[6];

		for (int i = 0; i <= 10000000; i++) {
			tirada = (int) (Math.random() * 6 + 1);
			/*	Random devuelve un double mayor o igual que 0,0 y menor que 1,0.
				Multiplicamos por 6 y quedará entre 0,0 y 5,9999.
				Sumamos 1 y queda entre 1,0 y 6,9999.
				Casteamos a int y queda entre 1 y 6, un dado. */
			totalesCara[tirada - 1]++;
		}

		for (int i = 0; i < totalesCara.length; i++) {
			System.out.println(
					"Total de " + (i + 1) + ": " + totalesCara[i] + ", un " + totalesCara[i] * 100.0 / 10000000 + "%");
		}
	}
}