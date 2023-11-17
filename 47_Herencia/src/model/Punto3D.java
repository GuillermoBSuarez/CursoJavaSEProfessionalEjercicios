package model;

public class Punto3D extends Punto {
	// Al heredar de Punto (extends) ya tiene x e y y el método dibujar().
	private int z;
	
	public Punto3D(int z) {			// Constructor con parámetro
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	/*
	public void dibujar() {
		System.out.println("Coordenadas: " + getX() + ", " + getY() + ", " + getZ());
	}
	*/
	
	public void dibujar() {
		super.dibujar();
		System.out.println(", " + getZ());
	}
}
