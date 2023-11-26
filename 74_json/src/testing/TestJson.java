package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.EmpleadosService;

class TestEmpleadosService {

	EmpleadosService es;
	
	@BeforeEach
	void setUp() throws Exception {
		es = new EmpleadosService();
	}

	@Test
	void testListaEmpleadosPorDepartamento() {
		assertEquals(2, es.listaEmpleadosPorDepartamento("sistemas").size());
		assertEquals(1, es.listaEmpleadosPorDepartamento("ventas").size());
	}

	@Test
	void testEmpleadoMayorSalario() {
		assertEquals("Javier", es.empleadoMayorSalario().getNombre());
	}

	@Test
	void testEmpleadoPorMail() {
		assertEquals("Laura", es.empleadoPorMail("lauri@gmail.es").getNombre());
	}
}