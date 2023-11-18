package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Curso;

public class Ordenar {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>(List.of(
				new Curso("Java básico", 100, LocalDate.of(2023, 11, 20), 350),
				new Curso("Spring", 60, LocalDate.of(2023, 10, 11), 350),
				new Curso("Angular", 40, LocalDate.of(2023, 10, 11), 125),
				new Curso("Hibernate", 30, LocalDate.of(2023, 10, 10), 80),
				new Curso("Python", 260, LocalDate.of(2023, 11, 20), 160)));
		
		// Ordenación por un campo:
		cursos.sort( (a, b) -> a.getFechaInicio().compareTo(b.getFechaInicio()) );
		
		/* Ordenación por dos campos:
		Con el método default .thenComparing:
		https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html#thenComparing(java.util.Comparator)
		Sort recibe un objeto Comparator, cuyo método abstracto compare devuelve un entero
		y lo implementamos de la forma:
		(a, b) -> a.getFechaInicio().compareTo(b.getFechaInicio())
		Pero a diferencia de otros objetos (String, Double, etc.), A LAS FUNCIONES LAMBDA
		NO SE LE PUEDEN APLICAR OTRAS FUNCIONES, así que no se puede añadir . y enlazar con otro
		de sus métodos, como hacemos con los streams, sino que hay que guardarla en una variable
		de ese tipo de objeto y, ahora sí, enlazarla con otra función. Eso hacemos para ordenar
		por dos campos, cada criterio en un objeto y... */
		Comparator<Curso> cmp1 = (a, b) -> a.getFechaInicio().compareTo(b.getFechaInicio());
		Comparator<Curso> cmp2 = (a, b) -> Integer.compare(a.getDuracion(), b.getDuracion());
		cursos.sort( cmp1.thenComparing(cmp2) );
	}
}