package clases;

import interfaces.Operaciones;

public class Mesa implements Operaciones {
	private int alto, largo, ancho;

	public Mesa(int alto, int largo, int ancho) {
		super();
		this.alto = alto;
		this.largo = largo;
		this.ancho = ancho;
	}

	@Override
	public void girar(int grados) {
		largo += grados;
		ancho += grados;
	}

	@Override
	public int invertir() {
		alto *= -1;
		return alto;
	}
}