package view;

import java.util.Scanner;

import service.NotasService;

public class ProgramaNotas {

	public static void main(String[] args) {
		Scanner scOp = new Scanner(System.in);
		
		NotasService notasService = new NotasService();
		
		int op = 0;
		do {
			menu();
			op = scOp.nextInt();
			
			switch (op) {
				case 1:
					System.out.print("Introduce nota: ");
					notasService.guardarNota(scOp.nextDouble());
					break;
				case 2:
					System.out.print("Introduce posición: ");
					notasService.eliminarNota(scOp.nextInt());
					break;
				case 3:
					System.out.println("La media es " + notasService.media());
					break;
				case 4:
					System.out.println("Aprobados: " + notasService.aprobados());
					break;
				case 5:
					op = 5;
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
}
