package service;

import java.util.ArrayList;

public class NotasService {
	ArrayList<Double> notas = new ArrayList<>();
	
	public void guardarNota(double nota){
		notas.add(nota);
	}
	
	public void eliminarNota(int nota){
		if (nota < notas.size()) {
			notas.remove(nota);
		}
	}
	
	public double media() {
		double media = 0;
		for (double d:notas) {
			media += d;
		}
		return media / notas.size();
	}
	
	public int aprobados() {
		int aprobados = 0;
		for (double d:notas) {
			if (d >= 5) { aprobados++; }
		}
		return aprobados;
	}
}
