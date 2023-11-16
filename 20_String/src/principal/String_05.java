package principal;

public class String_05 {

	public static void main(String[] args) {
		
		String cursos = "Ofimática,Java básico,JavaEE,Spring Boot,Angular,Programación avanzada en Java";
		String [] cursosArray = cursos.toLowerCase().split(",");
		
		int cursosJava = 0;
		
		for (String curso:cursosArray) {
			if (curso.contains("java")) {
				cursosJava++;
			}
		}
		System.out.println("Total de cursos de Java: " + cursosJava);
	}
}