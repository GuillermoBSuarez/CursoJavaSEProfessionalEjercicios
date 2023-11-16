package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.Pedido;
import service.ServicePedidos;

public class ServiceView {
	
	static ServicePedidos servicePedidos = new ServicePedidos();

	public static void main(String[] args) {

		Scanner scOp = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		
		int op = 0;
		do {
			menu();
			op = scOp.nextInt();
			
			switch (op) {
				case 1:
					grabar();
					break;
				case 2:
					Pedido p = servicePedidos.masReciente();
					System.out.println("Producto: " + p.producto()
									 + " - Fecha: " + p.fecha()
									 + " - Precio: " + p.precio());
					break;
				case 3:
					System.out.print("Precio máximo: ");
					for (Pedido ped:servicePedidos.pedidosInf(Double.parseDouble(scStr.nextLine()))) {
						System.out.println("Producto: " + ped.producto()
										 + " - Fecha: " + ped.fecha()
										 + " - Precio: " + ped.precio());
					}
					break;
				case 4:
					System.out.print("Meses a recuperar: ");
					for (Pedido ped:servicePedidos.pedidosAnt(Integer.parseInt(scStr.nextLine()))) {
						System.out.println("Producto: " + ped.producto()
										 + " - Fecha: " + ped.fecha()
										 + " - Precio: " + ped.precio());
					}
					break;
				case 5:
					System.out.println("Chao, pescao.");
					//scStr.close();
					//scOp.close();
					break;
				default:
					op = 0;
			}
		} while (op != 5);
	}
	
	private static void menu() {
		System.out.println();
		System.out.println("1. Nuevo pedido");
		System.out.println("2. Pedido más reciente");
		System.out.println("3. Pedidos con precio inferior");
		System.out.println("4. Pedidos anteriores");
			// pide un número de meses y devuelve los pedidos anteriores a ese número de meses
		System.out.println("5. Salir");
		System.out.print("INTRODUZCA UNA OPCIÓN: ");
	}
	
	static void grabar() {
		Scanner scStr = new Scanner(System.in);
		
		String producto;
		LocalDate fecha;
		double precio;

		System.out.print("Producto: ");
		producto = scStr.nextLine();
		
		System.out.print("Fecha (yyyy-MM-dd): ");
		try {
			fecha = LocalDate.parse(scStr.nextLine());
			
			System.out.print("Precio: ");
			precio = Double.parseDouble(scStr.nextLine());

			servicePedidos.guardar(producto, fecha, precio);
		}
		catch(DateTimeParseException ex) {
			System.out.println("La fecha no es válida y el pedido no se guardará");
		}
		
		// scStr.close();
	}
}
