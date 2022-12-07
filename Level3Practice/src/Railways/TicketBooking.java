package Railways;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TicketBooking 
{
	FileAccess fileAccess = new FileAccess();
	
	public <K, V> void createUser(User... user) throws IOException
	{
		int length = user.length;
		Map<Integer, User> userMap = new HashMap<Integer, User>();
		
		for(int i=0; i<length; i++)
		{
			userMap.put(user[i].getUserId(), user[i]);
		}
		fileAccess.writeFile("RailwayFiles/User/user.ser", userMap);
	}
	
	public boolean login(int userId, String password) throws ClassNotFoundException, IOException
	{
		Map<Integer, User> userMap = fileAccess.readFile("RailwayFiles/User/user.ser");
		
		if(userMap.containsKey(userId))
		{
			User user = userMap.get(userId);
			if(user.getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}
	
	public int checkAvailability(String Date) throws ClassNotFoundException, IOException
	{
		Map<String, Map<Long, Train>> dateMap = fileAccess.readTrainDetails("RailwayFiles/Train/train.ser");
		
		if(dateMap.containsKey(Date))
		{
			Map<Long, Train> train = dateMap.get(Date);
			int available = train.size();
			if(available < 10)
			{
				return 10-available;
			}
			return 0;
		}
		return 10;
	}
	
	public <K, V> void bookTickets(Map<String, Map<Long, Train>> dateMap, String path) throws IOException
	{
		fileAccess.fillTrainDetails(path, dateMap);
	}
	
	public Map<String, Map<Long, Train>> getTrainDetails(String path) throws ClassNotFoundException, IOException
	{
		Map<String, Map<Long, Train>> dateMap = fileAccess.readTrainDetails(path);
		return dateMap;
	}
}
