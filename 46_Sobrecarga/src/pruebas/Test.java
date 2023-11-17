package pruebas;

public class Test {

	public static void main(String[] args) {
		Operaciones operaciones = new Operaciones();
		operaciones.sum();
		operaciones.sum(1);
		operaciones.sum(1, 5);
		operaciones.sum(2, 4, 4, 140);
	}
}