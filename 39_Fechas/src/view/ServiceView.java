package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Pedido;
import service.ServicePedidos;

public class ServiceView {
	
	static ServicePedidos servicePedidos = new ServicePedidos();
	// Se crea como static para que la puedan ver todos los métodos de la clase Service View.
	// Si no sólo lo vería main.

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
					System.out.println("Chao, pescao.");
					break;
				default:
					op = 0;
			}
		} while (op != 4);
	}
	
	private static void menu() {
		System.out.println();
		System.out.println("1. Nuevo pedido");
		System.out.println("2. Pedido más reciente");
		System.out.println("3. Pedidos con precio inferior");
		System.out.println("4. Salir");
		System.out.print("INTRODUZCA UNA OPCIÓN: ");
	}
	
	static void grabar() {
		Scanner scStr = new Scanner(System.in);
		
		String producto;
		Date fecha;
		double precio;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");	//para el parseado de fechas

		System.out.print("Producto: ");
		producto = scStr.nextLine();
		
		System.out.print("Fecha (dd/MM/yyyy): ");
		try {
			fecha = format.parse(scStr.nextLine());
			
			System.out.print("Precio: ");
			precio = Double.parseDouble(scStr.nextLine());

			servicePedidos.guardar(producto, fecha, precio);
		}
		catch(ParseException ex) {
			System.out.println("La fecha no es válida y el pedido no se guardará");
		}
	}
}