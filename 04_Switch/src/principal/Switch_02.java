package principal;

public class Switch_02 {

	public static void main(String[] args) {
		int nota = 8;

		switch (nota) {
		case 1, 2, 3, 4: 	// Ojo, sólo a partir de java 17, en java 11 era:
							// case 1:
							// case 2:
							// case 3:
							// case 4:
							// System.out.println("Suspenso");
			System.out.println("Suspenso");
			break;
		case 5, 6:
			System.out.println("Aprobado");
			break;
		case 7, 8:
			System.out.println("Notable");
			break;
		case 9, 10:
			System.out.println("Sobresaliente");
			break;
		default:
			System.out.println("Nota no válida");
		}
	}
}