package task8;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.Month;

import java.time.format.DateTimeFormatter;

import java.time.format.TextStyle;

import java.util.Date;

import java.util.Locale;

import java.util.TimeZone;

public class TimeTask 
{
	
	public String getDateTime1()
	{
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dateTime.format(now);
	}
	
	public String getDateTime2()
	{
		LocalDateTime dateTime = LocalDateTime.now();
		return "" + dateTime;
	}
	
	public String getDateTime3(String inputString)
	{
		Date now = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone(inputString));
		return "" + now;
	}
	
	public String getDateTime4(String inputString) throws ParseException
	{
		Date sdf = new SimpleDateFormat("dd/MM/yyyy").parse(inputString);
		return new SimpleDateFormat("EE").format(sdf);
	}
	
	public String getDateTime5(int d, int m, int y) throws ParseException
	{
		LocalDate now = LocalDate.of(y, m, d);
		Month month = now.getMonth();
		return month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
	
	public int getDateTime6(int d, int m, int y) throws ParseException
	{
		LocalDate now = LocalDate.of(d, m, y);
		return now.getYear();
	}
	
}

















