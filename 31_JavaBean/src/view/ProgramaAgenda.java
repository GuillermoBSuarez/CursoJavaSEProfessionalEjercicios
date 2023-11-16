package view;

import java.util.Scanner;

import model.Contacto;
import service.AgendaService;

public class ProgramaAgenda {

	static AgendaService agendaService = new AgendaService();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		do {
			mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
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
		}while(opcion!=5);
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

		System.out.println("Introduce Email");
		String email = sc.nextLine();
		System.out.println("Introduce nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce edad:");
		int edad = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce teléfono:");
		int telefono = Integer.parseInt(sc.nextLine());
		
		agendaService.agregar(email, nombre, edad, telefono);
	}
	
	static void buscarContacto() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce email");
		String email = sc.nextLine();
		Contacto contacto = agendaService.buscar(email);
		if(contacto != null) {
			System.out.println(contacto.getNombre() + "-" + contacto.getEdad());
		} else {
			System.out.println("No se ha encontrado el contcto");
		}
	}

	static void eliminarContacto() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce email");
		String email = sc.nextLine();
		agendaService.eliminar(email);
	}
	
	static void mostrarNombres() {
		Contacto[] contactos = agendaService.contactos();
		for(Contacto c:contactos) {
			System.out.println(c.getNombre() + "-" + c.getEdad());
		}
	}
}