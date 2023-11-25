package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class TestCopiar {

	public static void main(String[] args) throws IOException {
		String dirOrigen = "C:\\temp\\origen\\para_copiar.txt";
		String dirDestino = "C:\\temp\\destino\\destino_copiar.txt";
		// Poner sólo hasta la carpeta de destino compila pero da una excepción.
		
		Files.copy(Path.of(dirOrigen), Path.of(dirDestino));
		/* Si el archivo destino existe da la excepción java.nio.file.FileAlreadyExistsException
		En ese caso, para sobreescribir hay que usar una constante del método
			java.lang.Object
				java.lang.Enum<StandardCopyOption>
					java.nio.file.StandardCopyOption */
		Files.copy(Path.of(dirOrigen), Path.of(dirDestino), StandardCopyOption.REPLACE_EXISTING);
	}
}