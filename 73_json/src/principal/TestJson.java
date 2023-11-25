// Adaptación de 72_nio

package principal;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Pedido;
import serialización.DeserializadorFecha;

public class TestJson {

	public static void main(String[] args) {
		
		/* Leer el json y mostrar su contenido como un objeto usando la librería gson.
		Conviene tener a mano la ayuda oficial:
		https://javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html */
		
		String dir = "C:\\temp\\pedidos.json";
		/* Gson gson = new Gson();
		Sería el método a utilizar normalmente, pero vamos a construir un nuevo Gson específico
		para poder incluir la clase deserializador para las fechas, así que usamos... */

		// PATTERN BUILDER / PATRÓN BUILDER
		Gson gson = new GsonBuilder()												// Devuelve un GsonBuilder.
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha())	// Devuelve un GsonBuilder.
				/* Añade el método deserializador y se podrían añadir más métodos para darle más propiedades */
				.create();															// Devuelve Gson
		
		// https://javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/com/google/gson/Gson.html#fromJson(java.io.Reader,java.lang.Class)
		try ( FileReader reader = new FileReader(dir); ) {
			Pedido[] pedido = gson.fromJson(reader, Pedido[].class);
			for (Pedido p:pedido) {
				System.out.println("Producto: " + p.getProducto());
				System.out.println("Fecha: " + p.getFechaPedido());
				System.out.println("Precio: " + p.getPrecio());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}