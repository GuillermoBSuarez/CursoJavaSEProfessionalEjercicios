package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestLectura {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("c:\\temp\\dias.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			int l = 0;
			while (linea != null) {
				System.out.println("Línea " + ++l + ": " + linea);
				linea = br.readLine();
			}
		} catch (FileNotFoundException fnf) { fnf.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
	}
}
