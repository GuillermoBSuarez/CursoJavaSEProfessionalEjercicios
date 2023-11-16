package principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test1 {

	public static void main(String[] args) {
		Date d1 = new Date();
		Date d2 = new Date(-999999999999l);
		
		if (d1.before(d2)) {
			System.out.println("Antigua: " + d1);
			System.out.println("Moderna: " + d2);
		} else {
			System.out.println("Antigua: " + d2);
			System.out.println("Moderna: " + d1);
		}
		
		// Métodos de Date: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Date.html
		
		// Formateado de fechas: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/text/SimpleDateFormat.html
		SimpleDateFormat fr = new SimpleDateFormat("dd/MM/yyyy");
		
		/* Lo aplicamos con el método format (el final) de DateFormat, la superclase de la que lo hereda SimpleDateFormat.
		Format recible un Date y devuelve un String:
		https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/text/DateFormat.html#format(java.util.Date) */
		System.out.println(fr.format(d2));
		System.out.println(fr.format(d1));
		
		// Formateado con localización:
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
		// No se instancia con new DateFormat es abstract, no tiene constructores. Ver patrón singleton.
		System.out.println(df.format(d2));
		
		// Parseado de fechas
		String f = "30-05-2022";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d3 = sdf.parse(f);				// "30-05-2022" se parsea a fecha de formato sdf, es decir, dd-MM-yyyy.
			System.out.println(df.format(d3));	// Luego se convierte a Date con formato df, es decir,
												// según la localización, que es España, así que añade el día de la semana.			
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("No válida");
		}
	}
}