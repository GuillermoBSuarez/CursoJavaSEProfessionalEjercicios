package principal;

import java.util.Scanner;

public class String_03 {

	public static void main(String[] args) {

		// Pide un e-mail y comprueba que tenga al menos un punto y una arroba

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca e-mail: ");
		String mail = sc.nextLine();

		if (mail.indexOf(".") > -1 && mail.indexOf("@") > -1) {
			System.out.println("e-mail correcto");
		} else {
			System.out.println("e-mail incorrecto");
		}
	}
}