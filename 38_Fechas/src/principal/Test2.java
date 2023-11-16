package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test2 {

	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2022, 11, 28);	// Sin new porque LocalDate no tiene constructores.
		LocalDate ld2 = LocalDate.of(2022, 8, 5);	// No 08 porque entendería que es un octal y los octales no admiten el 8.
		
		if (ld1.isBefore(ld2)) {
			System.out.println("La más antigua es " + ld1);
			System.out.println("La más reciente es " + ld2);
		} else {
			System.out.println("La más antigua es " + ld2);
			System.out.println("La más reciente es " + ld1);
		}
		
		// formateado de fechas
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(ld1.format(dtf));
		System.out.println(ld2.format(dtf));
		
		// parseado de fechas
		String f = "30/07/2021";
		LocalDate d3 = LocalDate.parse(f, dtf);
		System.out.println(d3);
		
		// extraer valores, algo que estaba deprecado en la clase Date
		System.out.println("Año: " + d3.getYear());
		System.out.println("Mes: " + d3.getMonth());
		System.out.println("Día: " + d3.getDayOfMonth());
		
		// cálculo de fechas, imposible en Date
		System.out.println(d3.plusMonths(6));
		System.out.println(d3.minusMonths(3));
	}
}