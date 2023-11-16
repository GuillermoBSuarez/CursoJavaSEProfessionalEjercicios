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
					Pedido pedido = servicePedidos.masReciente();
					System.out.println("Producto: " + pedido.getProducto()
									 + " - Fecha: " + pedido.getFecha()
									 + " - Precio: " + pedido.getPrecio());
					break;
				case 3:
					System.out.print("Precio máximo: ");
					for (Pedido p:servicePedidos.pedidosInf(Double.parseDouble(scStr.nextLine()))) {
						System.out.println("Producto: " + p.getProducto()
										 + " - Fecha: " + p.getFecha()
										 + " - Precio: " + p.getPrecio());
					}
					break;
				case 4:
					System.out.print("Meses a recuperar: ");
					for (Pedido p:servicePedidos.pedidosAnt(Integer.parseInt(scStr.nextLine()))) {
						System.out.println("Producto: " + p.getProducto()
										 + " - Fecha: " + p.getFecha()
										 + " - Precio: " + p.getPrecio());
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
		System.out.println("1. Nuevo pedido");
		System.out.println("2. Pedido más reciente");
		System.out.println("3. Pedidos con precio inferior");
		System.out.println("4. Pedidos anteriores");	// Pide un número de meses y devuelve los pedidos anteriores
														// a ese número de meses
		System.out.println("5. Salir");
		System.out.print("INTRODUZCA UNA OPCIÓN: ");
	}
	
	static void grabar() {
		Scanner scStr = new Scanner(System.in);
		
		String producto;
		LocalDate fecha;
		double precio;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Producto: ");
		producto = scStr.nextLine();
		
		System.out.print("Fecha (dd/MM/yyyy): ");
		try {
			fecha = LocalDate.parse(scStr.nextLine(), format);
			
			System.out.print("Precio: ");
			precio = Double.parseDouble(scStr.nextLine());

			servicePedidos.guardar(producto, fecha, precio);
		}
		catch(DateTimeParseException ex) {
			System.out.println("La fecha no es válida y el pedido no se guardará");
		}
	}
}