package onlinejob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import userException.UserDefinedException;

public class JobRunner 
{
	static Scanner scan = new Scanner(System.in);
	static UserStorage cach = new UserStorage();
	static JobLogic logical = new JobLogic();
	static JobRunner run = new JobRunner();
	
	static String userName;
	

	public static void main(String[] args) 
	{
		Applicant applicant;
		Company admin;
		System.out.println("USER LOGIN"
				+ "\n1) Applicant Login"
				+ "\n2) Admin Login"
				+ "\n3) Applicant Registration"
				+ "\n4) Admin Registration"
				+ "\n5) Exit");
		int login = scan.nextInt();
		
		while(login != -654)
		{
			switch(login)
			{
				case 1:
				{
					System.out.println("Enter User Name");
					userName = scan.next();
					
					System.out.println("Enter Password");
					String password = scan.next();
					
					if(logical.applicantLogin(userName, password))
					{
						run.applicantMethod();
						login = 0;
						break;
					}
					System.out.println("Invalid User Name or Password");
					login = 0;
					break;
				}
				
				case 2:
				{
					System.out.println("Enter User Name");
					userName = scan.next();
					
					System.out.println("Enter Password");
					String password = scan.next();
					
					if(logical.adminLogin(userName, password))
					{
						run.adminMethod();
						login = 0;
						break;
					}
					System.out.println("Invalid User Name or Password");
					login = 0;
					break;
				}
				
				case 3:
				{
					applicant = new Applicant();
					
					scan.nextLine();
					System.out.println("Enter Name");
					applicant.setName(scan.nextLine());
					
					System.out.println("Enter Mobile");
					applicant.setMobile(scan.nextLong());
					
					System.out.println("Enter E-mail");
					applicant.setEmail(scan.next());
					
					System.out.println("Enter User Name");
					applicant.setUserName(scan.next());
					
					System.out.println("Enter Password");
					applicant.setPassword(scan.next());
					
					if(logical.applicantRegistration(applicant))
					{
						System.out.println("------------------------------");
						System.out.println("|  Registration Successfull  |");
						System.out.println("------------------------------");
						login = 0;
						break;
					}
					System.out.println("----------------------------");
					System.out.println("|  UserName already Exist  |");
					System.out.println("----------------------------");
					login = 0;
					break;
				}
				
				case 4:
				{
					admin = new Company();
					
					scan.nextLine();
					System.out.println("Enter Name");
					admin.setName(scan.nextLine());
					
					System.out.println("Enter Mobile");
					admin.setMobile(scan.nextLong());
					
					System.out.println("Enter E-mail");
					admin.setEmail(scan.next());
					
					System.out.println("Enter User Name");
					admin.setUserName(scan.next());
					
					System.out.println("Enter Password");
					admin.setPassword(scan.next());
					
					if(logical.adminRegistration(admin))
					{
						System.out.println("------------------------------");
						System.out.println("|  Registration Successfull  |");
						System.out.println("------------------------------");
						login = 0;
						break;
					}
					System.out.println("----------------------------");
					System.out.println("|  UserName already Exist  |");
					System.out.println("----------------------------");
					login = 0;
					break;
				}
				
				case 5:
				{
					login = -654;
					break;
				}
				
				default:
				{
					System.out.println("USER LOGIN"
							+ "\n1) Applicant Login"
							+ "\n2) Admin Login"
							+ "\n3) Applicant Registration"
							+ "\n4) Admin Registration"
							+ "\n5) Exit");
					login = scan.nextInt();
					break;
				}
			}
		}
		
		
	}
	
	public void applicantMethod()
	{
		System.out.println("---------------------------------");
		System.out.println("|  Welcome to Applicant Portal  |");
		System.out.println("---------------------------------");
		
		System.out.println("Enter Choice"
				+ "\n1) Job Search"
				+ "\n2) View Applied Jobs"
				+ "\n3) Exit");
		int option = scan.nextInt();
		
		while(option != -654)
		{
			switch(option)
			{
				case 1:
				{
					System.out.println("Enter Job Type");
					scan.nextLine();
					String type = scan.nextLine();
					Map<String, String> jobMap = new HashMap<String, String>();
					jobMap = cach.getJobMap();
					List<String> jobList = new ArrayList<>();
					int i = 1;
					
					for(Map.Entry<String, String> map: jobMap.entrySet())
					{
						if(map.getKey().replace(" ", "").equalsIgnoreCase(type.replace(" ", "")))
						{
							jobList.add(map.getKey());
							System.out.println(i + ") " + map.getKey() + "----------->" + map.getValue());
							i++;
						}
					}
					
					System.out.println("Enter which Job You Want To Apply");
					int jobNo = scan.nextInt();
					logical.applyJob(userName, jobList.get(jobNo-1), jobMap.get(jobList.get(jobNo-1)));
					System.out.println("--------------------------------");
					System.out.println("Applied Successfully");
					option = 0;
					break;
				}
				
				case 2:
				{
					Map<String, String> viewJob = new HashMap<String, String>();
					
					try 
					{
						viewJob = logical.viewAppliedJob(userName);
						
						for(Map.Entry<String, String> map: viewJob.entrySet())
						{
							System.out.println(map);
						}
					} 
					catch (UserDefinedException ue) 
					{
						System.out.println("!!!!!!!!!!!");
						System.out.println(ue.getMessage());
						System.out.println("!!!!!!!!!!!");
					}
					option = 0;
					break;
				}
				
				case 3:
				{
					option = -654;
					break;
				}
				
				default:
				{
					System.out.println("Enter Choice"
							+ "\n1) Job Search"
							+ "\n2) View Applied Jobs"
							+ "\n3) Exit");
					option = scan.nextInt();
					break;
				}
			}
		}
		
		
	}
	
	public void adminMethod()
	{
		System.out.println("-------------------------------");
		System.out.println("|  Welcome to Company Portal  |");
		System.out.println("-------------------------------");
		
		System.out.println("Enter Choice"
				+ "\n1) Vaccency Registration"
				+ "\n2) View All Applicant Job"
				+ "\n3) Exit");
		int option = scan.nextInt();
		
		while(option != -654)
		{
			switch(option)
			{
				case 1:
				{
					Map<String, String> jobMap = new HashMap<String, String>();
					jobMap = cach.getJobMap();
					scan.nextLine();
					System.out.println("Enter Job Title");
					String title = scan.nextLine();
					
					System.out.println("Job Description");
					String description = scan.nextLine();
					jobMap.put(title, description);
					option = 0;
					break;
				}
				
				case 2:
				{
					Map<String, Map<String, String>> appliedJob = new HashMap<String, Map<String, String>>();
					try 
					{
						appliedJob = logical.viewAllAppliedJob();
						
						for(Entry<String, Map<String, String>> map: appliedJob.entrySet())
						{
							System.out.println(map);
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
					option = -654;
					break;
				}
				
				default:
				{
					System.out.println("Enter Choice"
							+ "\n1) Vaccency Registration"
							+ "\n2) View All Applicant Job"
							+ "\n3) Exit");
					option = scan.nextInt();
					break;
				}
				
			}
		}
	}

}





















