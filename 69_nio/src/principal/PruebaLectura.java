package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PruebaLectura {

	public static void main(String[] args) throws IOException {
		Path path = Path.of("c:\\temp\\productos.txt");

		Files.lines(path).forEach(linea -> System.out.println(linea));
	}
}