package com.kamabod.tech;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = input.nextInt();

		System.out.print("\nHow many accidents did you have? ");
		int accidents = input.nextInt();

		InsurProgram ip = new InsurProgram();
		ip.calculateTotal(age, accidents);

		input.close();
	}
}