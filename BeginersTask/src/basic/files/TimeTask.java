package basic.files;

import java.text.ParseException;
//import java.time.Clock;
import java.time.DayOfWeek;
//import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class TimeTask 
{
	
	public LocalDate getLocalDate()
	{
		return LocalDate.now();
	}
	
	public LocalDateTime getDateTime()
	{
		return LocalDateTime.now();
	}
	
	public long getTimeInMillis()
	{
		return System.currentTimeMillis();
//		return Clock.systemDefaultZone().millis();
//		return Instant.now().toEpochMilli();
	}
	
	public ZonedDateTime getZonedTime(ZoneId id)
	{
		return ZonedDateTime.now(id);
	}
	
	public DayOfWeek getDayOfDate(LocalDate Date) throws ParseException
	{
		DayOfWeek dayOfWeek = Date.getDayOfWeek();
		return dayOfWeek;
	}
	
	public Month getMonthOfDate(LocalDate Date) throws ParseException
	{
		Month month = Date.getMonth();
		return month;
	}
	
	public int getYearOfDate(LocalDate Date) throws ParseException
	{
		return Date.getYear();
	}
	
}

















