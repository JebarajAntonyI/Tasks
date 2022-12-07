package com.banking.methods;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BankUtil {
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

	public static String getTime(long milli)
	{
		LocalDateTime transactionDate = Instant.ofEpochMilli(milli).atZone(ZoneId.systemDefault()).toLocalDateTime();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return transactionDate.format(format);
	}

	public static long milliBeforeDays()
	{
		Instant currentDate = Instant.ofEpochMilli(System.currentTimeMillis());
		Instant beforeDate = currentDate.minus(Period.ofDays(7));
		return beforeDate.toEpochMilli();
	}

}
