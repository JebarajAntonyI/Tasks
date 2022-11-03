package com.banking.methods;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

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
	
	public static boolean mobileValidation(long mobile) throws UserDefinedException
	{
		InputValidityCheck.checkNull(mobile);
		String pattern = "^[6-9][0-9]{9}";
		if (String.valueOf(mobile).matches(pattern))
		{
			return true;
		}
		throw new UserDefinedException("Enter Valid Mobile Number");
	}
	
	public static boolean emailValidation(String email) throws UserDefinedException
	{
		InputValidityCheck.checkNull(email);
		String pattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9-]+.[a-zA-Z]+$";
		if (email.matches(pattern))
		{
			return true;
		}
		throw new UserDefinedException("Enter Valid Email ID");
	}

}
