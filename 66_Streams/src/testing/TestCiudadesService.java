package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.CiudadesService;

class TestCiudadesService {
	CiudadesService cs;
	
	@BeforeEach
	void setUp() throws Exception {
		cs = new CiudadesService();
		cs.altaCiudad("c1", "p1", 100_000, 23.5);
		cs.altaCiudad("c2", "p1", 200_000, 15.4);
		cs.altaCiudad("c3", "p2", 800_000, 22.0);
		cs.altaCiudad("c4", "p2", 70_000, 19.4);
		cs.altaCiudad("c5", "p2", 140_000, 15.6);
	}

	@Test
	void testTemperaturaInferior() {
		assertEquals(true, cs.temperaturaInferior(20));
		assertEquals(false, cs.temperaturaInferior(5));		
	}

	@Test
	void testCiudadMasPoblada() {
		assertEquals("c3", cs.ciudadMasPoblada().getNombre());
	}
	
	@Test
	void testTotalPaises() {
		assertEquals(2, cs.totalPaises());
	}
	
	@Test
	void testMediaHabitantesCiudadesPais() {
		assertEquals(150_000, cs.mediaHabitantesCiudadesPais("p1"));
	}
	
	@Test
	void testTemperaturaMasAlta() {
		assertEquals(23.5, cs.temperaturaMasAlta());
	}
}