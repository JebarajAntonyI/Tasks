package foodorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import userException.UserDefinedException;

public class FoodRunner 
{
	static Scanner scan = new Scanner(System.in);
	static FoodLogic logical = new FoodLogic();
	static FoodRunner run = new FoodRunner();

	public static void main(String[] args) 
	{
		System.out.println("Hey\n\n");
		System.out.println("Welcome to Food Ordering System");
		System.out.println("\n1) SignUp"
				+ "\n2) Login"
				+ "\n3) Exit");
		System.out.println("\nEnter Your Choice");
		int option = scan.nextInt();
		
		while(option != -65)
		{
			switch(option)
			{
				case 1:
				{
					Customer customer = new Customer();
					scan.nextLine();
					System.out.println("Enter Name");
					customer.setName(scan.nextLine());
					
					System.out.println("Enter Age");
					customer.setAge(scan.nextInt());
					
					System.out.println("Enter Email");
					customer.setEmail(scan.next());
					
					System.out.println("Enter Mobile");
					customer.setMobile(scan.nextLong());
					
					System.out.println("Enter Password");
					customer.setPassword(scan.next());
					
					System.out.println("Confirm Password");
					String confirm = scan.next();
					
					try
					{
						logical.signUp(customer, confirm);
						
						System.out.println("SignUp Successful");
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 2:
				{
					System.out.println("Enter Your Email");
					String email = scan.next();
					
					System.out.println("Enter Your Password");
					String pass = scan.next();
					
					try
					{
						if(logical.login(email, pass))
						{
							Map<String, Customer> customerMap = logical.showCustomers();
							
							Customer customer = customerMap.get(email);
							run.selectHotel(customer);
						}
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 3:
				{
					option = -65;
					break;
				}
				
				default:
				{
					System.out.println("Hey\n\n");
					System.out.println("Welcome to Food Ordering System");
					System.out.println("\n1) SignUp"
							+ "\n2) Login"
							+ "\n3) Exit");
					System.out.println("\nEnter Your Choice");
					option = scan.nextInt();
					break;
				}
			}
		}
	}
	
	public void selectHotel(Customer customer)
	{
		System.out.println("Welcome " + customer.getName() + ", You are Successfully logged in");
		
		System.out.println("\nWe Provide two ways of search"
				+ "\n1) Search By Hotels"
				+ "\n2) Search By Food"
				+ "\n3) Exit");
		System.out.println("\nEnter Your Choice");
		int option = scan.nextInt();
		
		while(option != -35)
		{
			switch(option)
			{
				case 1:
				{
					System.out.println("Choose the hotels"
							+ "\n1) Aarya Bhavan"
							+ "\n2) Banu Hotel"
							+ "\n3) SR Bhavan"
							+ "\n4) Exit");
					System.out.println("\nSelect the Hotel");
					int hotel = scan.nextInt();
					
					switch(hotel)
					{
						case 1:
						{
							Map<String, Integer> foodMap = logical.showFoodMap("Aarya Bhavan");
							orderFood(foodMap);
							break;
						}
						
						case 2:
						{
							Map<String, Integer> foodMap = logical.showFoodMap("Banu Hotel");
							orderFood(foodMap);
							break;
						}
						
						case 3:
						{
							Map<String, Integer> foodMap = logical.showFoodMap("SR Bhavan");
							orderFood(foodMap);
							break;
						}
						
						default:
						{
							break;
						}
					}
					option = 0;
					break;
				}
				
				case 2:
				{
					Map<String, Integer> foodMap = logical.showFoodMap("Common");
					orderFood(foodMap);
					option = 0;
					break;
				}
				
				case 3:
				{
					option = -35;
					break;
				}
				
				default:
				{
					System.out.println("\nWe Provide two ways of search"
							+ "\n1) Search By Hotels"
							+ "\n2) Search By Food"
							+ "\n3) Exit");
					System.out.println("\nEnter Your Choice");
					option = scan.nextInt();
					break;
				}
			}
		}
	}
	
	public void orderFood(Map<String, Integer> foodMap)
	{
		System.out.println("Choose the Food\n");
		List<String> foodList = new ArrayList<>();
		int i=1;
		
		for(Map.Entry<String, Integer> map : foodMap.entrySet())
		{
			foodList.add(map.getKey());
			System.out.println(i + ") " + map.getKey() + "  -  " + map.getValue());
			i++;
		}
		
		System.out.println(i + ") Cart");
		System.out.println(++i + ") Exit");
		System.out.println("Enter Your Choice");
		int choice = scan.nextInt();
		int price = 0;
		while(choice != i-1 || choice > i)
		{
			String dish = foodList.get(choice-1);
			price = price + foodMap.get(dish);
			choice = scan.nextInt();
		}
		
		if(choice == i-1)
		{
			System.out.println("------------------Cart------------------");
			System.out.println("Your Total Order Amount is " + price);
			
			System.out.println("\n\nDo You wish to Order (yes=press 1/no=press other)");
			
			if(scan.next().equals("1"))
			{
				System.out.println("Order Placed Successfully");
				System.out.println("......ThankYou......");
			}
			else
			{
				System.out.println("Order Canceled");
				System.out.println("......ThankYou......");
			}
		}
		else
		{
			System.out.println("......ThankYou......");
		}
	}

}





















