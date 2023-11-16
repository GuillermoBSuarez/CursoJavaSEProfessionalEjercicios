package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class NotasService {
	String fichero = "c:\\temp\\notas.txt";
	
	public void guardarNota(double nota){
		try (	FileOutputStream fos = new FileOutputStream(fichero, true);
				PrintStream ps = new PrintStream(fos)	) {
			ps.println(nota);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public void eliminarNota(int nota){}
	
	public double media() {
		double media = 0;
		int lineas = 0;
		
		try (	FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr)	) {	
			String linea = br.readLine();
			while (linea != null) {
				lineas++;
				media += Double.parseDouble(linea);
				linea = br.readLine();
			}
		} catch (IOException e) { e.printStackTrace(); }		
		return media / lineas;
	}
	
	public int aprobados() {
		int aprobados = 0;
		
		try (	FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr)	) {	
			String linea = br.readLine();
			if (Double.parseDouble(linea) >= 5) aprobados++;
		} catch (IOException e) { e.printStackTrace(); }	
		return aprobados;
	}
	
	public ArrayList<Double> notas() {
		ArrayList<Double> notas = new ArrayList<>();
		try (	FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr)	) {	
			String nota = br.readLine();
			while (nota != null) {
				notas.add(Double.parseDouble(nota));
				nota = br.readLine();
			}
		} catch (IOException e) { e.printStackTrace(); }
		return notas;
	}
}