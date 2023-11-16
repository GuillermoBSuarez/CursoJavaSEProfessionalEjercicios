package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestEscritura {

	public static void main(String[] args) {
		try (	FileOutputStream fos = new FileOutputStream("c:\\temp\\dias.txt", true);
				PrintStream ps = new PrintStream(fos)	) {
			ps.println("Lunes");
			ps.println("Martes");
			ps.println("Miércoles");
			ps.println("Jueves");
			ps.println("Viernes");
			ps.println("Sábado");
			ps.println("Domingo");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
