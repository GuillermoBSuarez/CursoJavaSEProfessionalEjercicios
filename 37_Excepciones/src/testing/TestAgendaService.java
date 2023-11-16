// https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.AgendaService;

class TestAgendaService {
	
	AgendaService service;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new AgendaService();
		service.agregar("mail1@mail1.com", "nombre1", 11, 11111);
		service.agregar("mail2@mail2.com", "nombre2", 22, 22222);
		service.agregar("mail3@mail3.com", "nombre3", 33, 33333);
		service.agregar("mail4@mail4.com", "nombre4", 44, 44444);			
		service.agregar("mail5@mail5.com", "nombre5", 55, 55555);
	}

	@Test
	void testAgregar() {
		assertTrue(service.agregar("mail6@mail6.com", "nombre6", 66, 66666));
		assertFalse(service.agregar("mail2@mail2.com", "nombre5", 55, 55555));
		assertEquals(6, service.contactos().length);
	}

	@Test
	void testEliminar() {
		assertTrue(service.eliminar("mail2@mail2.com"));
		assertFalse(service.eliminar("ddddd"));
	}

	@Test
	void testBuscar() {
		assertEquals("nombre4", service.buscar("mail4@mail4.com").getNombre());
	}

	@Test
	void testContactos() {
		assertEquals(5, service.contactos().length);
	}
}