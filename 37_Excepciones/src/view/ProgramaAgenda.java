package view;

import java.util.Scanner;

import model.Contacto;
import service.AgendaService;

public class ProgramaAgenda {

	static AgendaService agendaService = new AgendaService();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		do {
			try {
				mostrarMenu();
				opcion = Integer.parseInt(sc.nextLine());
					/* Aunque opcion es int no sirve recogerla con sc.nextInt() porque en la variable se incluye
					el salto de línea final, con lo que al evaluar evalúa lo tecleado y el salto de línea,
					así que entra de nuevo en catch y bucle infinito. Total, que para recoger números por teclado
					es mejor usar siempre nextLine() y convertirlo a Integer por parseInt. No sirve castear con (int)
					porque nextLine recoge un String y no se pueden castear objetos, sólo tipos primitivos.
					Y OJO: EN CASA SÍ ACEPTA nextInt sin problemas. */
				switch (opcion) {
				case 1:
					pedirContacto();
					break;
				case 2:
					buscarContacto();
					break;
				case 3:
					eliminarContacto();
					break;
				case 4:
					mostrarNombres();
					break;
				case 5:
					System.out.println("Chao, pescao");
				}
			} catch (NumberFormatException ex) {
					// Con nextInt() sería un InputMismatchException, pero con nextLine cambia.
				System.out.println("¡Un número, imbécil!");
			}
		} while (opcion != 5);
	}

	static void mostrarMenu() {
		System.out.println("1.- Nuevo contacto");
		System.out.println("2.- Buscar contacto");
		System.out.println("3.- Eliminar contacto");
		System.out.println("4.- Mostrar nombres");
		System.out.println("5.- Salir");
	}

	static void pedirContacto() {
		Scanner sc = new Scanner(System.in);
		String email;
		String nombre;
		int edad, telefono;
		System.out.println("Introduce Email");
		email = sc.nextLine();
		System.out.println("Introduce nombre");
		nombre = sc.nextLine();
		System.out.println("Introduce edad:");
		edad = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce teléfono:");
		telefono = Integer.parseInt(sc.nextLine());
		agendaService.agregar(email, nombre, edad, telefono);
	}

	static void buscarContacto() {
		Scanner sc = new Scanner(System.in);
		String email;
		Contacto contacto;
		System.out.println("Introduce email");
		email = sc.nextLine();
		contacto = agendaService.buscar(email);
		if (contacto != null) {
			System.out.println(contacto.getNombre() + "-" + contacto.getEdad());
		} else {
			System.out.println("No se ha encontrado el contcto");
		}
	}

	static void eliminarContacto() {
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Introduce email");
		email = sc.nextLine();
		agendaService.eliminar(email);
	}

	static void mostrarNombres() {
		Contacto[] contactos = agendaService.contactos();
		for (Contacto c : contactos) {
			System.out.println(c.getNombre() + "-" + c.getEdad());
		}
	}
}