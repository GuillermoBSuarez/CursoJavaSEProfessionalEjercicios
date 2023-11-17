package clases;

public class Punto {
	private int x, y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto() {
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
		System.out.println("Coordenadas: " + x + y);
	}
}