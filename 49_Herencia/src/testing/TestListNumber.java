package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.ListNumber;

class TestListNumber {
	
	ListNumber listNumber;

	@BeforeEach
	void setUp() throws Exception {
		listNumber = new ListNumber();
		listNumber.add(5);
		listNumber.add(10);
		listNumber.add(15);
	}

	@Test
	void testFirst() {
		assertEquals(5, listNumber.first());
	}

	@Test
	void testLast() {
		assertEquals(15, listNumber.last());
	}

	@Test
	void testSum() {
		assertEquals(30, listNumber.sum());
	}

	@Test
	void testAdd() {
		assertFalse(listNumber.add(10));
	}
}