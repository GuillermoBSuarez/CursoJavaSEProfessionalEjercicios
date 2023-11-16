package principal;

public class Metodos_01 {

	public static void main(String[] args) {
		
		// Calcular la nota media, la mayor, la menor y total de aprobados.
		
		String notas = "4.5,2.7,8.9,5.1,3.4,9.0,6.7,7.2";

		String[] notasTexto = notas.split(",");
		
		double mayor = Double.parseDouble(notasTexto[0]),
			   menor = Double.parseDouble(notasTexto[0]),
			   total = 0;
		int aprobados = 0;

		for (String n:notasTexto) {
			if (Double.parseDouble(n) > mayor) { mayor = Double.parseDouble(n); }
			if (Double.parseDouble(n) < menor) { menor = Double.parseDouble(n); }
			if (Double.parseDouble(n) >= 5) { aprobados++; }
			total += Double.parseDouble(n);
		}
			
		System.out.println("Nota mayor: " + mayor);
		System.out.println("Nota menor: " + menor);
		System.out.println("Nota media: " + total/notasTexto.length);
		System.out.println("Aprobados: " + aprobados);
	}
}