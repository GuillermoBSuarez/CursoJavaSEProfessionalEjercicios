package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestLectura {

	public static void main(String[] args) {
		try (	FileReader fr = new FileReader("c:\\temp\\dias.txt");
				BufferedReader br = new BufferedReader(fr)	) {	

			String linea = br.readLine();
			int l = 0;
			while (linea != null) {
				System.out.println("Línea " + ++l + ": " + linea);
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			// No ponemos la excepción FileNotFoundException porque es hija de IOException, así que si cogemos ésta
			// también servirá para FileNotFoundException. Por ese mismo motivo no podemos poner
			//		catch (FileNotFoundException | IOException e)
 			// porque no se admite con clases herederas.
		}
	}
}
