package principal;

public class String_01 {

	public static void main(String[] args) {
		String cad1 = "hola";
		String cad2 = " adios";

		// Concatenación:
		cad1 += cad2;							// cad1 = cad1 + cad2
		System.out.println(cad1);
		System.out.println(cad1.length());
		System.out.println(cad1.toUpperCase());
	}
}