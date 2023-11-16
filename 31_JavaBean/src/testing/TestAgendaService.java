// https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.AgendaService;

class TestAgendaService {
	
	AgendaService service;		// Instanciamos service en cada prueba (cada java de JUnit) para machacar lo que hubiese.
	
	/* Primero se ejecuta el setUp, si lo hay, y después el resto en orden IMPREDECIBLE. Por tanto,
	no podemos diseñar pruebas de, por ejemplo, eliminar un registro contando con que dicho registro
	se creó antes en un método agregar(), porque a lo mejor se ejecutan en orden inverso. */
	
	@BeforeEach		/* Obliga a ejecutar este método (crear los registros) ANTES de cada uno de los demás.
					Así nos aseguramos de que siempre existirán los datos con los que operan el resto */
	void setUp() throws Exception {
		service = new AgendaService();
		service.agregar("mail1@mail1.com", "nombre1", 11, 11111);
		service.agregar("mail2@mail2.com", "nombre2", 22, 22222);
		service.agregar("mail3@mail3.com", "nombre3", 33, 33333);
		service.agregar("mail4@mail4.com", "nombre4", 44, 44444);			
		service.agregar("mail5@mail5.com", "nombre5", 55, 55555);
	}

	@Test		// Imprescindible o no lanzará el método como prueba.
	void testAgregar() {
		// El método agregar devuelve un boolen, por lo que probamos tanto si devuelve True como False.
		
		assertTrue(service.agregar("mail6@mail6.com", "nombre6", 66, 66666));
		/* Entre los datos que metemos en setUp no está este registro, por lo que si ejecutamos agregar() con estos datos
		primero comprueba si existen y luego los graba y devuelve True. Eso es lo que comprobamos: assertTrue */

		assertFalse(service.agregar("mail2@mail2.com", "nombre5", 55, 55555));
		// En setUp ya introdujimos un mail2, así que agregar comprobará que existe, no lo grabará y devolverá False

		assertEquals(6, service.contactos().length);
		// Afirmamos (assert) que es igual (Equals) 6 que la longitud de contactos: los 5 de setUp más el del primer assert.
		
		// Lo suyo sería un método por cada supuesto.
	}

	@Test
	void testEliminar() {
		
		assertTrue(service.eliminar("mail2@mail2.com"));
		// Afirmamos (assert) que eliminar devolverá True porque le enviarmos un mail que existe, encontrará el registro y lo borrará
		
		assertFalse(service.eliminar("ddddd"));
	}

	@Test
	void testBuscar() {
		assertEquals("nombre4", service.buscar("mail4@mail4.com").getNombre());
		/* buscar devuelve un objeto Contacto, por lo que no podemos evaluar assertTrue o assertFalse sino el objeto.
		Y no podemos evaluar directamente un valor sino una propiedad del objeto, por eso getNombre. */
	}

	@Test
	void testContactos() {
		assertEquals(5, service.contactos().length);
		// Como antes, devuelve un objeto, un Array de objetos. Por tanto, evaluamos la longitud del array.
	}
}