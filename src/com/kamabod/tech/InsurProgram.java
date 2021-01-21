package com.kamabod.tech;

import java.util.HashMap;
import java.util.Map;

public class InsurProgram {

	int basicInsurance = 500;
	int surcharge = 100; // under 25 years

	public int calculateTotal(int age, int accidents) {
		if (age < 0)
			throw new IllegalArgumentException("Please enter a valid number:");

		if (accidents < 0)
			throw new IllegalArgumentException("Please enter a valid number:");

		int ageSurcharge = this.getAgeSurcharge(age);
		int total = 0;
		switch (accidents) {
		case 0:
			System.out.println("\nNo surcharge");
			System.out.println("\nTotal amount to pay: " + (total = basicInsurance + ageSurcharge));
			break;
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("\n" + "Additional surcharge for accidents: " + getAccidentSurcharge(accidents) + "\n"
					+ "\nTotal amount to pay: "
					+ (total = basicInsurance + getAccidentSurcharge(accidents) + ageSurcharge));
			break;
		}

		if (accidents >= 6)
			System.out.println("\nNo insurance");

		return total;
	}

	public int getAgeSurcharge(int age) {
		int surchargeValue = 0;
		if (age < 25) {
			surchargeValue = surcharge;
			System.out.println("\nAdditional surcharge for age " + surchargeValue);
		} else {
			surchargeValue = 0;
			System.out.println("\nNo additional surcharge for age");
		}
		return surchargeValue;
	}

	public int getAccidentSurcharge(int accidents) {
		@SuppressWarnings("serial")
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
			{
				put(0, 0);
				put(1, 50);
				put(2, 125);
				put(3, 225);
				put(4, 375);
				put(5, 575);
			}
		};
		return map.get(accidents);
	}
}