package foodorder;

import java.util.Map;

import userException.UserDefinedException;

public class FoodLogic 
{
	FoodStorage cach = new FoodStorage();
	
	public Map<String, Customer> showCustomers()
	{
		return cach.getCustomerMap();
	}
	
	public void signUp(Customer customer, String confirm) throws UserDefinedException
	{
		int length = customer.getPassword().length();
		if(length < 8 || length > 12)
		{
			if(length < 8)
			{
				throw new UserDefinedException("Your Password is very short"
						+ "\nLength must between 8 to 12");
			}
			throw new UserDefinedException("Your Password is very long"
					+ "\nLength must between 8 to 12");
		}
		else if(!customer.getPassword().equals(confirm))
		{
			throw new UserDefinedException("Password & Confirm Password not Matched");
		}
		Map<String, Customer> customerMap = showCustomers();
		if(customerMap.get(customer.getEmail()) != null)
		{
			throw new UserDefinedException("Account Already Existed. Please Login !!");
		}
		customerMap.put(customer.getEmail(), customer);
	}
	
	public boolean login(String email, String password) throws UserDefinedException
	{
		Map<String, Customer> customerMap = showCustomers();
		if(customerMap.get(email) == null)
		{
			throw new UserDefinedException("Account Not Existed. Please SignUp !!");
		}
		Customer customer = customerMap.get(email);
		if(customer.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
	public Map<String, Integer> showFoodMap(String hotel)
	{
		Map<String, Map<String, Integer>> hotelMap = cach.getFoodMap();
		
		return hotelMap.get(hotel);
	}
}

































