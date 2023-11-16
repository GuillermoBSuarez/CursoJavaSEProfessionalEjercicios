package principal;

public class String_04 {

	public static void main(String[] args) {

		String localidad = "Alcalá de Henares, (Madrid)";

		System.out.println(localidad.substring(localidad.indexOf("(") + 1, localidad.indexOf(")")));
	}
}