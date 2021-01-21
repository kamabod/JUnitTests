package com.kamabod.tech;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.Assert.assertEquals;

class TestGetAgeSurcharge {

	InsurProgram ip;

	@BeforeEach
	public void setUp() {
		ip = new InsurProgram();
	}

	@Test
	public void testAgeSurchargeAssertNotEquals() {
		int age = 17;

		int returnedAgeSurcherge = ip.getAgeSurcharge(age);

		assertNotEquals(0, returnedAgeSurcherge);
	}

	@Test
	public void testAgeSurchargeTestAssertNotEquals1() {
		int age = 70;

		int returnedAgeSurcherge = ip.getAgeSurcharge(age);

		assertNotEquals(100, returnedAgeSurcherge);
	}

	@ParameterizedTest
	@CsvSource(value = { "18:100", "25:0", "49:0" }, delimiter = ':')
	void testAgeSurchargeParameterized(int age, int expectedValue) {
		int returnedAgeSurcherge = ip.getAgeSurcharge(age);

		assertEquals(expectedValue, returnedAgeSurcherge);
	}

	@AfterEach
	public void tearDown() {
		System.out.println("Method finished");
		ip = null;
	}
}
