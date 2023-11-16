package principal;

import java.util.Scanner;

public class Scanner_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Escribe tu nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Te llamas " + nombre);

		System.out.print("Primer número: ");
		int num1 = sc.nextInt();
		System.out.print("Segundo número: ");
		int num2 = sc.nextInt();
		System.out.println("La suma de " + num1 + " y " + num2 + " es " + (num1 + num2));
	}
}