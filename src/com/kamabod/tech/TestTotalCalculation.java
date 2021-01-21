package com.kamabod.tech;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class TestTotalCalculation { 

	public static InsurProgram ip;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		ip = new InsurProgram();
	}

	@Test
	public void testTotalNotEquals() {
		int age = 27;
		int accidents = 1;

		int total = ip.calculateTotal(age, accidents);

		assertNotEquals(1000, total);
	}

	@Test
	public void testTotalAssertNotEquals() {
		int age = 27;
		int accidents = 2;

		int total = ip.calculateTotal(age, accidents);

		assertNotEquals(500, total);
	}

	@Test 
	@Timeout(value = 2, unit = TimeUnit.MILLISECONDS)
	public void testTotalTimeOut() {
		int age = 27;
		int accidents = 2;

		int total = ip.calculateTotal(age, accidents);

		assertNotEquals(500, total);
	}

	@Test
	public void testNoInsurancdToManyAccidents() {
		int age = 54;
		int accidents = 10;

		int total = ip.calculateTotal(age, accidents);

		assertTrue(total == 0, "Expected 0 for no Insurance");
	}

	@Test
	public void testMustHaveInsurance() {
		int age = 20;
		int accidents = 3;

		int total = ip.calculateTotal(age, accidents);

		assertFalse(total == 0, "Expected to have Insurance");
	}

	@ParameterizedTest
	@CsvSource(value = { "18:0:600", "31:1:550", "50:5:1075", "62:2:625" }, delimiter = ':')
	public void testTotalParameterized(int age, int accidents, int expectedResult) {
		int returnedtotal = ip.calculateTotal(age, accidents);

		assertEquals(expectedResult, returnedtotal);
	}

	@Test
	public void testInvalidAccidentsInput() {
		int age = 25;
		int accidents = -10;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ip.calculateTotal(age, accidents);
		});
	}

	@Test
	public void testInvalidAgeInput() {
		int age = -18;
		int accidents = 1;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ip.calculateTotal(age, accidents);
		});
	}

}
