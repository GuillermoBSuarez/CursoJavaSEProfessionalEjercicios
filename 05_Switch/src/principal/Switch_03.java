package principal;

public class Switch_03 {

	public static void main(String[] args) {

		double precio = 4.5;
		int unidades = 3;

		switch (unidades) {
		case 5, 6, 7:
			System.out.println("Precio final: " + precio * unidades * 0.9);
			break;
		case 3, 4:
			System.out.println("Precio final: " + precio * unidades * 0.95);
			break;
		case 1, 2:
			System.out.println("Precio final: " + precio * unidades);
			break;
		default:
			System.out.println("No válido");
		}

		// Con expresión switch (Java 17):

		double pFinal = switch (unidades) {
			case 5, 6, 7 -> precio * unidades * 0.9;
			case 3, 4 -> precio * unidades * 0.95;
			case 1, 2 -> precio * unidades;
			default -> -1;
		};
		System.out.println("Precio total: " + pFinal);
	}
}