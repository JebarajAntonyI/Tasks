package hotel;

public class HotelDetails 
{
	public HotelDetails(String name, int rooms, String location, int rating, int price)
	{
		this.name = name;
		this.rooms = rooms;
		this.location = location;
		this.rating = rating;
		this.price = price;
	}
	
	private String name;
	private int rooms;
	private String location;
	private int rating;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Name=" + name + "\nRooms=" + rooms + "\nLocation=" + location + "\nRating=" + rating
				+ "\nPrice=" + price;
	}
}
