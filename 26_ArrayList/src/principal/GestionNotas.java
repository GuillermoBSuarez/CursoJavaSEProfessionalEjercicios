package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionNotas {

	public static void main(String[] args) {
		
		Scanner scOp = new Scanner(System.in);
		
		ArrayList<Double> notas = new ArrayList<>();
				
		int op = 0;
		do {
			menu();
			op = scOp.nextInt();
			
			switch (op) {
				case 1:
					System.out.print("Introduce nota: ");
					notas.add(scOp.nextDouble());
					break;
				case 2:
					System.out.print("Introduce posición: ");
					notas.remove(scOp.nextInt());
					break;
				case 3:
					System.out.println("La media es " + media(notas));
					break;
				case 4:
					System.out.println("Aprobados: " + aprobados(notas));
					break;
				case 5:
					System.out.println("Chao, pescao.");
					break;
				default:
					op = 0;
			}
		} while (op != 5);
	}

	private static void menu() {
		System.out.println("1. Añadir nota");
		System.out.println("2. Eliminar nota por posición");
		System.out.println("3. Nota media");
		System.out.println("4. Total de aprobados");
		System.out.println("5. Salir");
		System.out.print("INTRODUZCA UNA OPCIÓN: ");
	}
	
	private static int aprobados(ArrayList<Double> notas) {
		int aprobados = 0;
		for (double d:notas) {
			if (d >= 5) { aprobados++; }
		}
		return aprobados;		
	}

	private static double media(ArrayList<Double> notas) {
		double media = 0;
		for (double d:notas) {
			media += d;
		}
		return media / notas.size();
	}
}