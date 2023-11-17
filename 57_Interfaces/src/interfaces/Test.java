package interfaces;

import java.util.Scanner;

interface External {			// Interfaz para envío y recepción de textos.
	void send(String texto);
	String read();				// abstract implícito en ambas.
	
	/* Método estático que proporciona una implementación por defecto de esta interfaz
	con envío de datos a la pantalla y lectura desde el teclado */
	static External ext() {
		return new External() {
			@Override
			public void send(String texto) {
				System.out.println(texto);				
			}

			@Override
			public String read() {
				Scanner sc = new Scanner(System.in);
				return sc.nextLine();
			}			
		};
	}
}

public class Test {
	public static void main(String[] args) {
		String cad = "Hola, mundo";
		External.ext().send(cad);
		System.out.print("Teclea: ");
		System.out.println("Has metío: " + External.ext().read());
	}
}