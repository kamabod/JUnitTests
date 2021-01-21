package com.kamabod.tech;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestGetAccidentSurcharge { 
	InsurProgram ip;

	@BeforeEach
	public void setUp() {
		ip = new InsurProgram();
	}

	@Test 
	public void testAccidentsNullPointerException() {
		int accidents = 1000;
		Assertions.assertThrows(NullPointerException.class, () -> {
			ip.getAccidentSurcharge(accidents);
		});
	}

	@ParameterizedTest
	@CsvSource(value = { "1:50", "2:125", "3:225", "4:375", "5:575" }, delimiter = ':')
	public void testGetAccidentSurcharge(int accidents, int accidentsSurcharge) {
		int returnedAccidentSurcharge = ip.getAccidentSurcharge(accidents);
		assertEquals(accidentsSurcharge, returnedAccidentSurcharge);
	}

	@Test 
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void testAccidentsSurchargeTimeOut() throws Exception {
		int accidents = 1;
		int returnedValue = ip.getAccidentSurcharge(accidents);
		assertEquals(50, returnedValue);
	}

	@AfterAll
	public static void tearDown() throws Exception {
		System.out.println("Finished. Tear down all");
	}

	@AfterEach
	public void finalise() {
		System.out.println("Method finished");
		ip = null;
	}
}