package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestMover {

	public static void main(String[] args) throws IOException {
		String dirOrigen = "C:\\temp\\origen\\para_mover.txt";
		String dirDestino = "C:\\temp\\destino\\destino_mover.txt";

		Files.move(Path.of(dirOrigen), Path.of(dirDestino));
		// Si no hay archivo origen lanza una excepción java.nio.file.NoSuchFileException
	}
}