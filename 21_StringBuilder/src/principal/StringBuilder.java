package principal;

public class StringBuilder {

	public static void main(String[] args) {

		// Crear una nueva cadena sólo con los productos que empiezan por A.

		String productos = "Detergente,Vino,Pan,Agua,Leche,Harina,Mantequilla,Arroz";

		String[] datos = productos.split(",");
		StringBuilder resultado = new StringBuilder();

		for (String d : datos) {
			if (d.startsWith("A")) {
				resultado.append(d);
				resultado.append(",");
			}
		}

		System.out.println(resultado.deleteCharAt(resultado.length() - 1)); // borramos la última coma
	}
}