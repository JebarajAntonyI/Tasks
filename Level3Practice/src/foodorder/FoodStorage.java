package foodorder;

import java.util.HashMap;
import java.util.Map;

public class FoodStorage 
{
	public FoodStorage()
	{
		initialise();
	}
	
	private Map<String, Customer> customerMap = new HashMap<>();
	private Map<String, Map<String, Integer>> foodMap = new HashMap<String, Map<String, Integer>>();
	
	public void initialise()
	{
		Customer one = new Customer("Jose", 20, "jose@gmail.com", "Jose@123", 8888888888L);
		
		customerMap.put(one.getEmail(), one);
		
		Map<String, Integer> foods = new HashMap<String, Integer>();
		foods.put("Sandwich", 70);
		foods.put("Pizza", 100);
		foods.put("Fried Rice", 95);
		foods.put("Parotta", 15);
		foods.put("Noodles", 75);
		foods.put("Chicken Rice", 80);
		foods.put("Chicken Briyani", 90);
		foods.put("Prawn", 120);
		foods.put("Faloda", 35);
		foodMap.put("Common", foods);
		
		foods = new HashMap<String, Integer>();
		foods.put("Sandwich", 70);
		foods.put("Pizza", 100);
		foods.put("Fried Rice", 95);
		foodMap.put("Aarya Bhavan", foods);
		
		foods = new HashMap<String, Integer>();
		foods.put("Parotta", 15);
		foods.put("Noodles", 75);
		foods.put("Chicken Rice", 80);
		foodMap.put("Banu Hotel", foods);
		
		foods = new HashMap<String, Integer>();
		foods.put("Chicken Briyani", 90);
		foods.put("Prawn", 120);
		foods.put("Faloda", 35);
		foodMap.put("SR Bhavan", foods);
	}

	public Map<String, Customer> getCustomerMap() {
		return customerMap;
	}

	public Map<String, Map<String, Integer>> getFoodMap() {
		return foodMap;
	}
}
