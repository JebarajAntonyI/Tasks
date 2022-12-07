package hotel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HotelRunner 
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) 
	{
		HotelStorage store = new HotelStorage();
		
		List<HotelDetails> hotelList = store.getHotelList();
		List<Booking> bookingList = store.getBookingList();
		System.out.println("Enter Your Choice"
				+ "\n1) Print the hotel data"
				+ "\n2) Sort hotels by Name"
				+ "\n3) Sort Hotel by highest rating"
				+ "\n4) Print Hotel data for a Location (Chennai or Madurai)"
				+ "\n5) Sort hotels by maximum number of rooms Available"
				+ "\n6) Print user Booking data"
				+ "\n7) Exit");
		int option = scan.nextInt();
		
		while(option != -346)
		{
			switch(option)
			{
				case 1:
				{
					System.out.println("-------------------------------------");
					System.out.println("PRINT HOTELS DATA:");
					System.out.println("-------------------------------------");
					
					for(HotelDetails i : hotelList)
					{
						System.out.println(i);
						System.out.println("-------------------------------------");
					}
					option = 0;
					break;
				}
				
				case 2:
				{
					System.out.println("-------------------------------------");
					System.out.println("SORT BY NAME:");
					System.out.println("-------------------------------------");
					
					Collections.sort(hotelList, new Comparator<HotelDetails>() {
						@Override
						public int compare(HotelDetails o1, HotelDetails o2)
						{
							return (o2.getName()).compareTo(o1.getName());
						}
					});
					for(HotelDetails i : hotelList)
					{
						System.out.println(i);
						System.out.println("-------------------------------------");
					}
					option = 0;
					break;
				}
				
				case 3:
				{
					System.out.println("-------------------------------------");
					System.out.println("SORT BY RATING:");
					System.out.println("-------------------------------------");
					
					Collections.sort(hotelList, new Comparator<HotelDetails>() {
						@Override
						public int compare(HotelDetails o1, HotelDetails o2) 
						{
							return ((Integer)o2.getRating()).compareTo(o1.getRating());
						}
					});
					for(HotelDetails i : hotelList)
					{
						System.out.println(i);
						System.out.println("-------------------------------------");
					}
					option = 0;
					break;
				}
				
				case 4:
				{
					System.out.println("-------------------------------------");
					System.out.println("Enter Location");
					String location = scan.next();
					System.out.println("-------------------------------------");
					
					for(HotelDetails i : hotelList)
					{
						if(i.getLocation().equalsIgnoreCase(location))
						{
							System.out.println(i);
							System.out.println("-------------------------------------");
						}
					}
					option = 0;
					break;
				}
				
				case 5:
				{
					System.out.println("-------------------------------------");
					System.out.println("SORT BY ROOMS AVAILABLE:");
					System.out.println("-------------------------------------");
					
					Collections.sort(hotelList, new Comparator<HotelDetails>() {
						@Override
						public int compare(HotelDetails o1, HotelDetails o2) 
						{
							return ((Integer)o2.getRooms()).compareTo(o1.getRooms());
						}
					});
					for(HotelDetails i : hotelList)
					{
						System.out.println(i);
						System.out.println("-------------------------------------");
					}
					option = 0;
					break;
				}
				
				case 6:
				{
					System.out.println("-------------------------------------");
					System.out.println("PRINT USER BOOKING DATA:");
					System.out.println("-------------------------------------");
					
					for(Booking i : bookingList)
					{
						System.out.println(i);
						System.out.println("-------------------------------------");
					}
					option = 0;
					break;
				}
				
				case 7:
				{
					option = -346;
					break;
				}
				
				default:
				{
					System.out.println("Enter Your Choice"
							+ "\n1) Print the hotel data"
							+ "\n2) Sort hotels by Name"
							+ "\n3) Sort Hotel by highest rating"
							+ "\n4) Print Hotel data for a Location (Chennai or Madurai)"
							+ "\n5) Sort hotels by maximum number of rooms Available"
							+ "\n6) Print user Booking data"
							+ "\n7) Exit");
					option = scan.nextInt();
				}
			}
		}
	}

}













