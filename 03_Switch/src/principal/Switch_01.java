package principal;

public class Switch_01 {

	public static void main(String[] args) {
		int precio = 6;

		switch (precio) {
		case 10:
			System.out.println("Muy caro");
			break;
		case 9:
			System.out.println("Caro");
			break;
		case 8:
			System.out.println("Aceptable");
			break;
		case 7:
			System.out.println("Lo compro");
			break;
		case 6:
			System.out.println("Barato");
			break;
		default:
			System.out.println("Preico no válido");
		}
	}
}
