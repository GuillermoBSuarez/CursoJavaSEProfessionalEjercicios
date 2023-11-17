package clases;

import interfaces.Operaciones;

public class Punto3D extends Punto implements Operaciones {
	private int z;
	
	public Punto3D(int z) {					// Constructor
		this.z = z;
	}
	
	public Punto3D(int x, int y, int z) {	// Constructor
		super(x,y);
		this.z = z;
	}

	public int getZ() { return z; }

	public void setZ(int z) { this.z = z; }
	
	public void dibujar() {
		super.dibujar();
		System.out.println(", " + getZ());
	}

	@Override				// Sobreescrito obligatoriamente por implementar la interfaz Operaciones
	public void girar(int grados) {
		setX(getX() + grados);
	}

	@Override				// Sobreescrito obligatoriamente por implementar la interfaz Operaciones
	public int invertir() {
		z = -10;
		return z;
	}
}