package principal;

import java.util.ArrayList;

import model.Alumno;

public class PruebaBean {

	public static void main(String[] args) {
		Alumno alumno = new Alumno("alumno 1", "Java 21", 45);
		System.out.println("El alumno es del curso: " + alumno.getCurso());
		alumno.setEdad(12);

		ArrayList<Alumno> alumnos = new ArrayList<>();
		alumnos.add(alumno);
	}
}