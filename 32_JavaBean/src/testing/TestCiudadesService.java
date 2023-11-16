package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.CiudadesService;

class TestCiudadesService {
	static CiudadesService service = new CiudadesService();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service.guardarCiudad("Madrid", 3500000, "España");
		service.guardarCiudad("Sevilla", 1000000, "España");
		service.guardarCiudad("París", 5700000, "Francia");
		service.guardarCiudad("Bruselas", 800000, "Bélgica");
		service.guardarCiudad("Barcelona", 1800000, "España");
	}

	@Test
	void testGuardarCiudad() {
		service.guardarCiudad("Burdeos", 100000, "Francia");
		assertEquals(2, service.ciudadesPorPais("Francia").size());
	}

	@Test
	void testCiudadMasPoblada() {
		assertEquals("París", service.ciudadMasPoblada().getNombre());
	}

	@Test
	void testCiudadesPorPais() {
		assertEquals(3, service.ciudadesPorPais("España").size());
	}

	@Test
	void testEliminarCiudad() {
		service.eliminarCiudad("Sevilla");
		assertEquals(2, service.ciudadesPorPais("España").size());
	}
}