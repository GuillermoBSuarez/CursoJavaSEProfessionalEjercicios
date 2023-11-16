package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class String_02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce texto: ");
		String cad = sc.nextLine();
		String vocales = "aeiou";
		
		int totVocales = 0;
		
		for (char c:cad.toCharArray()) {
			for (int i = 0; i < vocales.length(); i++) {
				if (c == vocales.toCharArray()[i]) {
					totVocales++;
				}
			}
		}
		
		System.out.println("Total de vocales: " + totVocales);
	}
}