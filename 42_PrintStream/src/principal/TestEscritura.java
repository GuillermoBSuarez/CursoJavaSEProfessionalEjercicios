package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestEscritura {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		PrintStream out = null;
		try {
			/* Primer método:
			out = new PrintStream("c:\\temp\\dias.txt");
			Sobreescribe siempre el archivo, pues lo crea cada vez que ejecutamos. */
				
			// Segundo método:
			fos = new FileOutputStream("c:\\temp\\dias.txt", true);
			// FileOutputStream(archivo, append), en este caso append = true, es decir, abrir en modo añadir.
			out = new PrintStream(fos);			// Creamos el PrintStream a partir del objeto fos creado

			out.println("Lunes");
			out.println("Martes");
			out.println("Miércoles");
			out.println("Jueves");
			out.println("Viernes");
			out.println("Sábado");
			out.println("Domingo");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out != null) out.close();
			if (fos != null)
				try { fos.close(); }
				catch (IOException e) { e.printStackTrace(); }
			/* El cierre de objetos se hace en el finally para asegurarnos de que en cualquier caso lo hace.
			Pero entonces hay que poner la declaración de out fuera del try o no la vería finally.
			Peeero entonces hay que inicializarla o da error.
			Y además hay que cerrarlos en el orden inverso al que se abrieron.
			Y además el cierre de FileOutputStream puede lanzar excepción, con lo que obliga a oootro try catch. */
		}
	}
}