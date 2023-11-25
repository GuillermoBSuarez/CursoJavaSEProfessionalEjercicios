package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
  
public class PruebaEscritura {

	public static void main(String[] args) throws IOException {
		/* throws sale de la sugerencia de ayuda que provoca la línea de Files.write,
		que también ofrece implementar un try-catch. */
		
		String dir = "c:\\temp\\productos.txt";
		
		List<String> productos = List.of("pan","agua","filete","pizza","fanta");
		
		// Guardar en fichero
		Path path = Path.of(dir);
		Files.write(path, productos);
		
		/* Write (para colecciones) y writeString (para cadenas)
		crean el archivo o sobreescriben si existe.

		El tercer parámetro de write (y similares) es OpenOption, opciones de apertura,
		para evitar sobreescribir, entre otras cosas.
		Clase Files: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Files.html
		Vamos al método write y su parámetro OpenOption: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/OpenOption.html
		No tiene nada, así que vamos a una clase que la implementa, StandardOpenOption: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/StandardOpenOption.html
		Esta tiene varias constantes para definir el tipo de apertura, como APPEND: */
		
		// Guarda un nuevo producto
		Files.writeString(path, "cerveza", StandardOpenOption.APPEND);
	}
}