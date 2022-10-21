package com.tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetInput {
	Scanner scan = new Scanner(System.in);

	public int getIntegerInput() {
		int number = 0;
		boolean value = true;
		while (value) {
			if (scan.hasNextInt()) {
				number = scan.nextInt();
				value = false;
			} else {
				scan.next();
				System.out.print("Enter value in Integer: ");
			}
		}
		return number;
	}

	public long getLongInput() {
		long number = 0;
		boolean value = true;
		while (value) {
			if (scan.hasNextLong()) {
				number = scan.nextLong();
				value = false;
			} else {
				scan.next();
				System.out.print("Enter value in Integer: ");
			}
		}
		return number;
	}

	public double getDoubleInput() {
		double number = 0;
		boolean value = true;
		while (value) {
			if (scan.hasNextDouble()) {
				number = scan.nextDouble();
				value = false;
			} else {
				scan.next();
				System.out.print("Enter value in Integer: ");
			}
		}
		return number;
	}

	public <T> ArrayList<T> getNewArrayList() {
		return new ArrayList<T>();
	}

	public <T, U> HashMap<T, U> getNewHashMap() {
		return new HashMap<T, U>();
	}

}
