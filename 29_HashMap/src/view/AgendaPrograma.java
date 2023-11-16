package view;

import java.util.Scanner;

import service.AgendaService;

public class AgendaPrograma {

	public static void main(String[] args) {

		Scanner scOp = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		
		AgendaService agendaService = new AgendaService();
		
		int op = 0;
		do {
			menu();
			op = scOp.nextInt();
			
			String nombre = "", email = "";
			
			switch (op) {
				case 1:
					System.out.print("Introduce nombre: ");
					nombre = scStr.nextLine();
					System.out.print("Introduce e-mail: ");
					email = scStr.nextLine();
					if (agendaService.nuevo(email, nombre)){
						System.out.println("Añadido.");
					} else {
						System.out.println("Ya existe.");
					}
					break;
				case 2:
					System.out.print("Introduce mail: ");
					nombre = agendaService.busca(scStr.nextLine());
					if (nombre != null) {
						System.out.println("Nombre: " + nombre);
					} else {
						System.out.println("No existe el contacto.");
					}
					break;
				case 3:
					System.out.print("Introduce mail: ");
					if (agendaService.borra(scStr.nextLine())) {
						System.out.println("Kaput");
					} else {
						System.out.println("No existe el contacto.");
					}
					break;
				case 4:
					for (String n:agendaService.listar()) {
						System.out.println(n);
					}
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
		System.out.println();
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar contacto");
		System.out.println("3. Eliminar contacto");
		System.out.println("4. Listar contactos");
		System.out.println("5. Salir");
		System.out.print("INTRODUZCA UNA OPCIÓN: ");
	}
}