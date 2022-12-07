package Railways;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RailRunner 
{

	static Scanner scan = new Scanner(System.in);
	
	static int userId;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		TicketBooking ticketBooking = new TicketBooking();
		
		System.out.print("Enter User Id: ");
		userId = scan.nextInt();
		System.out.print("Enter Password: ");
		String password = scan.next();

		if(ticketBooking.login(userId, password))
		{
			System.out.println("Press"
					+ "\n1) Reservation"
					+ "\n2) PNR Enquiry"
					+ "\n3) Cancel Ticket"
					+ "\n4) Exit");
			int option = scan.nextInt();
			
			while(option != -456)
			{
				A:
				switch(option)
				{
					case 1:
					{
						int trainNo = 136548;
						String trainName = "Chennai Express";
						
//							System.out.println("Enter Date of Journey");
//							String date = scan.next();
						System.out.println("Choose Boarding Station"
								+ "\n1) Madurai"
								+ "\n2) Tambaram");
						int no = scan.nextInt();
						
						String boarding;
						switch(no)
						{
						case 1:
							boarding = "Madurai";
							break;
							
						case 2:
							boarding = "Tambaram";
							break;
							
						default:
							System.out.println("Invalid Station");
							break A;
						}
						
						System.out.println("Choose Destination Station"
								+ "\n1) Tambaram"
								+ "\n2) Chennai");
						no = scan.nextInt();
						
						String destination;
						switch(no)
						{
						case 1:
							destination = "Tambaram";
							break;
							
						case 2:
							destination = "Chennai";
							break;
							
						default:
							System.out.println("Invalid Station");
							break A;
						}
						
						if(boarding.equals(destination))
						{
							System.out.println("----------------------------------------------------");
							System.out.println("Boarding Station & Destination Station Must not Same");
							System.out.println("----------------------------------------------------");
							break A;
						}
						
						System.out.println("Enter Date of Journey(dd/mm/yyyy)");
						String date = scan.next();
						
						String ticketClass;
						String name;
						int age;
						String sex;
						String status;
						
						int available = ticketBooking.checkAvailability(date);
						if(available>0)
						{
							System.out.println("Available Number of Tickets: " + available);
							
							System.out.println("Class Sleeper");
							ticketClass = "Sleeper";
							
							scan.nextLine();
							System.out.print("Enter Name: ");
							name = scan.nextLine();
							
							System.out.print("Enter Age: ");
							age = scan.nextInt();
							
							System.out.print("Enter Sex: ");
							sex = scan.next();
							
							status = "Confirm";
						}
						else
						{
							System.out.println("Available Number of Tickets: " + available
									+ "\nBook for Waiting List");
							
							System.out.println("Class Sleeper");
							ticketClass = "Sleeper";
							
							scan.nextLine();
							System.out.print("Enter Name: ");
							name = scan.nextLine();
							
							System.out.print("Enter Age: ");
							age = scan.nextInt();
							
							System.out.print("Enter Sex: ");
							sex = scan.next();
							
							status = "Waiting";
						}
						
						System.out.println("Press 1 to Confirm Booking");
						int confirm = scan.nextInt();
						
						if (confirm == 1) 
						{
							Train train = new Train();
							train.setUserId(userId);
							train.setPnr(System.currentTimeMillis());
							train.setTrainNo(trainNo);
							train.setTrainName(trainName);
							train.setClassType(ticketClass);
							train.setDate(date);
							train.setFrom(boarding);
							train.setTo(destination);
							train.setSeatNo(available);
							train.setStatus(status);
							train.setPassengerName(name);
							train.setAge(age);
							train.setSex(sex);
							Map<Long, Train> trainMap = new HashMap<>();
							trainMap.put(train.getPnr(), train);
							Map<String, Map<Long, Train>> dateMap = ticketBooking.getTrainDetails("RailwayFiles/Train/train.ser");
							dateMap.put(date, trainMap);
							ticketBooking.bookTickets(dateMap, "RailwayFiles/Train/train.ser");
							
							System.out.println("Ticket Booked Successfully");
							System.out.println(train);
							option = 0;
						}
						else
						{
							System.out.println("Ticket Not Booked");
							option = 0;
						}
						break;
					}
					
					case 2:
					{
						System.out.println("Enter PNR number");
						long pnr = scan.nextLong();
						System.out.println("Enter Date of Journey(dd/mm/yyyy)");
						String date = scan.next();
						
						Map<String, Map<Long, Train>> dateMap = new HashMap<String, Map<Long,Train>>();
						dateMap = ticketBooking.getTrainDetails("RailwayFiles/Train/train.ser");
						Map<Long, Train> trainMap = new HashMap<Long, Train>();
						trainMap = dateMap.get(date);
						
						Train train = null;
						if(trainMap != null)
						{
							train = trainMap.get(pnr);
						}
						if(train != null)
						{
							System.out.println("---------------------------------------------");
							System.out.println(train);
							System.out.println("---------------------------------------------");
						}
						else
						{
							Map<String, Map<Long, Train>> cancelDateMap = new HashMap<String, Map<Long,Train>>();
							cancelDateMap = ticketBooking.getTrainDetails("RailwayFiles/Train/canceled.ser");
							Map<Long, Train> cancelMap = new HashMap<Long, Train>();
							cancelMap = cancelDateMap.get(date);
							Train cancelTrain = null;
							if(cancelMap != null)
							{
								cancelTrain = cancelMap.get(pnr);
							}
							if(cancelTrain != null)
							{
								System.out.println(cancelTrain);
							}
							else
							{
								System.out.println("Invalid PNR");
							}
						}
						option = 0;
						break;
					}
					
					case 3:
					{
						System.out.println("Enter PNR number");
						long pnr = scan.nextLong();
						System.out.println("Enter Date of Journey(dd/mm/yyyy)");
						String date = scan.next();
						
						Map<String, Map<Long, Train>> dateMap = new HashMap<String, Map<Long,Train>>();
						dateMap = ticketBooking.getTrainDetails("RailwayFiles/Train/train.ser");
						Map<Long, Train> trainMap = new HashMap<Long, Train>();
						trainMap = dateMap.get(date);
						
						Train train = null;
						if(trainMap != null)
						{
							train = trainMap.get(pnr);
						}
						if(train != null)
						{
							System.out.println("----------------------------");
							System.out.println(train);
							System.out.println("----------------------------");
							
							System.out.println("Press 1 to Cancel Ticket");
							int cancel = scan.nextInt();
							
							if(cancel == 1)
							{
								trainMap.remove(pnr);
								dateMap.put(date, trainMap);
								ticketBooking.bookTickets(dateMap, "RailwayFiles/Train/train.ser");
								
								
								Map<String, Map<Long, Train>> cancelDateMap = new HashMap<String, Map<Long,Train>>();
								Map<Long, Train> cancelMap = new HashMap<Long, Train>();
								train.setStatus("Canceled");
								cancelMap.put(pnr, train);
								cancelDateMap.put(date, cancelMap);
								ticketBooking.bookTickets(cancelDateMap, "RailwayFiles/Train/canceled.ser");
								System.out.println("-------------------------------");
								System.out.println("Ticket Canceled Successfully");
							}
						}
						else
						{
							System.out.println("Invalid PNR");
						}
						option = 0;
						break;
					}
					
					case 4:
					{
						option = -456;
						break;
					}
					
					default:
					{
						System.out.println("Press"
								+ "\n1) Reservation"
								+ "\n2) PNR Enquiry"
								+ "\n3) Cancel Ticket"
								+ "\n4) Exit");
						option = scan.nextInt();
						break;
					}
				}
			}
		}
		else
		{
			System.out.println("Invalid ID or Password");
		}
		
	}
	
	
	public void booking()
	{
		
	}
	

}










//User user = new User();
//User user2 = new User();
//user.setUserId(1);
//user.setPassword("12345");
//
//user2.setUserId(2);
//user2.setPassword("12345");
//
//ticketBooking.createUser(user, user2);










