package view;

import java.util.Scanner;

import service.ServiceProductos;

public class ServiceView {
	
	public static void main(String[] args) {

		var servicio = new ServiceProductos();
		
		// BLOQUE DE PRUEBA
		servicio.altaProducto("p1", 60, "cat1");
		servicio.altaProducto("p2", 50, "cat2");
		servicio.altaProducto("p3", 40, "cat3");
		servicio.altaProducto("p4", 30, "cat4");
		servicio.altaProducto("p5", 20, "cat5");
		servicio.altaProducto("p6", 10, "cat6");
		
		servicio.bajarPrecios(5);
		servicio.subirPrecioCategoria(10, "cat1");
		servicio.eliminarPorCategoria("cat2");
		servicio.ordenarPorPrecio();
		servicio.obtenerProductos().forEach(p -> System.out.println(p.getNombre() + ": " + p.getPrecio() + ": " + p.getCategoria()));
		// FIN BLOQUE DE PRUEBA

		Scanner scOp = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		
		int op = 0;
		do {
			menu();
			op = scOp.nextInt();
			
			String producto = "";
			double precio;
			int porcentaje = 0;
			String categoria = "";
			
			switch (op) {
				case 1:		// Nuevo producto: pide datos y guarda
					scOp = new Scanner(System.in);
					scStr = new Scanner(System.in);

					System.out.print("Producto: ");
					producto = scStr.nextLine();
					
					System.out.print("Precio: ");
					precio = scOp.nextDouble();
					
					System.out.print("Categoría: ");
					categoria = scStr.nextLine();
					
					servicio.altaProducto(producto, precio, categoria);
					break;
				case 2:		// Bajar precios: pide porcentaje y baja todos
					System.out.print("Porcentaje: ");
					servicio.bajarPrecios(scOp.nextInt());
					break;
				case 3:		// Ordenar productos: ordena por precio, no muestra nada
					servicio.ordenarPorPrecio();
					break;
				case 4:		// Eliminar productos: pide categoría y elimina todos los de la misma
					System.out.print("Categoría: ");
					servicio.eliminarPorCategoria(scStr.nextLine());
					break;
				case 5:		// Subir precios por categoría: pide categoría y porcentaje y sube sólo los de esa categoría
					System.out.print("Categoría: ");
					categoria = scStr.nextLine();
					
					System.out.print("Porcentaje: ");
					porcentaje = scOp.nextInt();
					
					servicio.subirPrecioCategoria(porcentaje, categoria);
					break;
				case 6:		// Mostrar todos los productos
					break;
				case 7:
					System.out.println("Chao, pescao.");
					break;
				default:
					op = 0;
			}
		} while (op != 7);
	}
	
	private static void menu() {
		System.out.println();
		System.out.println("1. Nuevo producto");
		System.out.println("2. Bajar precios");
		System.out.println("3. Ordenar productos");
		System.out.println("4. Eliminar productos");
		System.out.println("5. Subir precios por categoría");
		System.out.println("6. Mostrar todos los productos");
		System.out.println("7. Salir");
		System.out.print("INTRODUZCA UNA OPCIÓN: ");
	}
}