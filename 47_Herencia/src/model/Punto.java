package model;

public class Punto {
	private int x, y;

	public Punto(int x, int y) {	// Constructor con parámetros	
		this.x = x;
		this.y = y;
	}
	
	public Punto() {				// Constructor por defecto
		x = 20;
		y = 10;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void dibujar() {
		System.out.print("Coordenadas: " + x + ", " + y);
	}
}
