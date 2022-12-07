package hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelStorage 
{
	public HotelStorage()
	{
		initialise();
	}
//	Map<String, List<HotelDetails>> nameMap = new HashMap<>();
//	Map<Integer, List<HotelDetails>> ratingMap = new HashMap<>();
//	Map<String, List<HotelDetails>> locationMap = new HashMap<>();
//	Map<String, List<HotelDetails>> roomsMap = new HashMap<>();
	private List<HotelDetails> hotelList = new ArrayList<>();
	private List<Booking> bookingList = new ArrayList<>();
	
	
	public List<Booking> getBookingList() {
		return bookingList;
	}


	public List<HotelDetails> getHotelList() {
		return hotelList;
	}


	public void initialise()
	{
		HotelDetails one = new HotelDetails("H1", 4, "Banglore", 5, 100);
		HotelDetails two = new HotelDetails("H2", 5, "Banglore", 5, 200);
		HotelDetails three = new HotelDetails("H3", 6, "Mumbai", 3, 100);
		
		hotelList.add(one);
		hotelList.add(two);
		hotelList.add(three);
		
		Booking u1 = new Booking("U1", 2, "H1", 1000);
		Booking u2 = new Booking("U2", 3, "H2", 1200);
		Booking u3 = new Booking("U3", 4, "H3", 1100);
		
		bookingList.add(u1);
		bookingList.add(u2);
		bookingList.add(u3);
	}
}
