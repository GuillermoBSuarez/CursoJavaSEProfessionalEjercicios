package principal;

public class Metodos_02 {
	
	public static void main(String[] args) {
		
		// Calcular la nota media, la mayor, la menor y total de aprobados.
		
		String notas = "4.5,2.7,8.9,5.1,3.4,9.0,6.7,7.2";
		String [] notasTexto = notas.split(",");
		System.out.println("Nota mayor: " + mayor(notasTexto));
		System.out.println("Nota menor: " + menor(notasTexto));
		System.out.println("Nota media: " + media(notasTexto));
		System.out.println("Aprobados: " + aprobados(notasTexto));
	}
	
	static double media(String datos[]) {		// Debe ser static. Un método static (main) sólo puede llamar
		double total = 0;							// a otros métodos static de la misma clase.
		for (String d:datos) {
			total += Double.parseDouble(d);
		}
		return total / datos.length;
	}
	
	static int aprobados(String datos[]) {
		int aprobados = 0;
		for (String d:datos) {
			if (Double.parseDouble(d) >= 5) { aprobados++; }
		}
		return aprobados;
	}
	
	static double mayor(String datos[]) {
		double mayor = Double.parseDouble(datos[0]);
		for (String d:datos) {
			if (Double.parseDouble(d) > mayor) { mayor = Double.parseDouble(d); }
		}
		return mayor;
	}
	
	static double menor(String datos[]) {
		double menor = Double.parseDouble(datos[0]);
		for (String d:datos) {
			if (Double.parseDouble(d) < menor) { menor = Double.parseDouble(d); }
		}
		return menor;
	}
}