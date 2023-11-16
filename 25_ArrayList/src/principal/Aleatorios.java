package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aleatorios {

	public static void main(String[] args) {

		// Pide y guarda enteros hasta que el usuario diga "no", entonces muestra la suma.

		ArrayList<Integer> nums = new ArrayList<>();

		Scanner scNum = new Scanner(System.in);
		Scanner scSeg = new Scanner(System.in);

		String seguir = "s";
		while (seguir.equals("s")) {
			System.out.print("Introduzca un número: ");
			nums.add(scNum.nextInt());	/* Aunque ArrayList sólo acepta objetos, por la propiedad
										de autoboxing convierte el int a Integer. */
			System.out.print("¿Seguir? (s/n) ");
			seguir = scSeg.nextLine();
		}

		int total = 0;
		for (int n : nums) {
			total += n;
		}

		System.out.print("Suma total: " + total);

		scNum.close();
		scSeg.close();
	}
}