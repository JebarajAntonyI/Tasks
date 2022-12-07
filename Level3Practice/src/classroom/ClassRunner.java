package classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import userException.UserDefinedException;

public class ClassRunner 
{

	static Scanner scan = new Scanner(System.in);
	static ClassroomLogic logical = new ClassroomLogic();
	static ClassRunner run = new ClassRunner();
	
	static String mail;
	
	public static void main(String[] args) 
	{
		System.out.println("Choose Option"
				+ "\n1) Signin"
				+ "\n2) Student SignUp"
				+ "\n3) Faculty SignUp"
				+ "\n4) Admin SignUp"
				+ "\n5) Exit");
		int option = scan.nextInt();
		
		while(option != -465)
		{
			switch(option)
			{
				case 1:
				{
					System.out.println("Enter Email");
					mail = scan.next();
					
					System.out.println("Enter Password");
					String password = scan.next();
					
					try
					{
						if(logical.login(mail, password))
						{
							Map<String, UserDetails> userMap = logical.getSpecificUserDetails(mail);
							UserDetails user = userMap.get(mail);
							
							if(user.getRoll().equalsIgnoreCase("Admin"))
							{
								run.admin(user);
							}
							else if(user.getRoll().equalsIgnoreCase("Faculty"))
							{
								run.faculty(user);
							}
							else
							{
								run.student(user);
							}
						}
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
					UserDetails user = run.signup();
					
					user.setRoll("Student");
					
					try
					{
						logical.createUser(user);
						
						System.out.println("Signup Request Submited");
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
					UserDetails user = run.signup();
					
					user.setRoll("Faculty");
					
					try
					{
						logical.createUser(user);
						
						System.out.println("Signup Request Submited");
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 4:
				{
					UserDetails user = run.signup();
					
					user.setRoll("Admin");
					
					try
					{
						logical.createUser(user);
						
						System.out.println("Signup Request Submited");
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 5:
				{
					option = -465;
					break;
				}
				
				default:
				{
					System.out.println("Choose Option"
							+ "\n1) Signin"
							+ "\n2) Student SignUp"
							+ "\n3) Faculty SignUp"
							+ "\n4) Admin SignUp"
							+ "\n5) Exit");
					option = scan.nextInt();
				}
			}
		}
		
	}
	
	public UserDetails signup()
	{
		UserDetails user = new UserDetails();
		
		scan.nextLine();
		System.out.println("Enter Name");
		user.setName(scan.nextLine());
		
		System.out.println("Enter E-Mail");
		user.setMail(scan.next());
		
		System.out.println("Enter Mobile");
		user.setMobile(scan.nextLong());
		
		System.out.println("Enter Password");
		user.setPassword(scan.next());
		
		return user;
	}
	
	public void student(UserDetails user)
	{
		System.out.println("Choose Option"
				+ "\n1) Edit Profile"
				+ "\n2) Study Materials"
				+ "\n3) Ask Doubts"
				+ "\n4) View Answers"
				+ "\n5) Exit");
		int option = scan.nextInt();
		
		while(option != -165)
		{
			switch(option)
			{
				case 1:
				{
					user = signup();
					mail =user.getMail();
					user.setStatus("APPROVED");
					try
					{
						logical.modifyUser(user);
						System.out.println("Updated SuccessFully");
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
					try
					{
						Map<Integer, StudyMaterials> studyMap = logical.displayMaterials();
						
						for(Map.Entry<Integer, StudyMaterials> map: studyMap.entrySet())
						{
							System.out.println("Material Number: " + map.getKey());
							System.out.println(map.getValue());
							System.out.println("-------------------------------------------------------");
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
					Doubts doubt = new Doubts();
					scan.nextLine();
					System.out.println("Enter Your Doubt");
					
					doubt.setQuestion(scan.nextLine());
					try
					{
						logical.askDoubt(doubt);
						
						System.out.println("Doubt Posted Successfully");
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 4:
				{
					Map<Integer, Doubts> answerMap = new HashMap<Integer, Doubts>();
					try
					{
						answerMap = logical.getAnswers();
						
						for(Map.Entry<Integer, Doubts> map : answerMap.entrySet())
						{
							Doubts doubt = map.getValue();
							
							System.out.println("Question: " + doubt.getQuestion());
							System.out.println("Answer: " + doubt.getAnswer() + "\n\n\n");
						}
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 5:
				{
					option = -165;
					break;
				}
				
				default:
				{
					System.out.println("Choose Option"
							+ "\n1) Edit Profile"
							+ "\n2) Study Materials"
							+ "\n3) Ask Doubts"
							+ "\n4) View Answers"
							+ "\n5) Exit");
					option = scan.nextInt();
				}
			}
		}
	}
	
	public void faculty(UserDetails user)
	{
		System.out.println("Choose Option"
				+ "\n1) Edit Profile"
				+ "\n2) Post Study Materials"
				+ "\n3) Show Doubts & Give Answers"
				+ "\n4) View Answered Doubts"
				+ "\n5) Exit");
		int option = scan.nextInt();
		
		while(option != -165)
		{
			switch(option)
			{
				case 1:
				{
					user = signup();
					mail =user.getMail();
					user.setStatus("APPROVED");
					try
					{
						logical.modifyUser(user);
						System.out.println("Updated SuccessFully");
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
					StudyMaterials material = new StudyMaterials();
					scan.nextLine();
					System.out.println("Post Link Address or Any Materials");
					material.setMaterials(scan.nextLine());
					material.setEmail(user.getMail());
					material.setFaculty(user.getName());
					
					try
					{
						logical.provideMaterials(material);
						
						System.out.println("Materials Posted Successfully");
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
					try
					{
						Map<Integer, Doubts> doubtMap = logical.displayDoubts();
						Map<Integer, Integer> count = new HashMap<Integer, Integer>();
						
						int i = 0;
						for(Map.Entry<Integer, Doubts> map : doubtMap.entrySet())
						{
							if(map.getValue().getAnswer() == null)
							{
								count.put(++i, map.getKey());
								System.out.println(i + ") " + map.getValue().getQuestion());
							}
						}
						
						System.out.println("Press 1 to Answer the Questions or other to exit");
						
						if(scan.nextInt() == 1)
						{
							System.out.println("Enter Question Number to Answer");
							int num = scan.nextInt();
							
							scan.nextLine();
							System.out.println("Enter Answer");
							Doubts doubt = new Doubts();
							doubt.setAnswer(scan.nextLine());
							doubt.setNumber(count.get(num));
							
							logical.giveAnswer(doubt);
							System.out.println("Answer Posted Successfully");
						}
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 4:
				{
					Map<Integer, Doubts> answerMap = new HashMap<Integer, Doubts>();
					try
					{
						answerMap = logical.getAnswers();
						
						for(Map.Entry<Integer, Doubts> map : answerMap.entrySet())
						{
							Doubts doubt = map.getValue();
							
							if(doubt.getAnswer() != null)
							{
								System.out.println("Question: " + doubt.getQuestion());
								System.out.println("Answer: " + doubt.getAnswer() + "\n\n\n");
							}
						}
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 5:
				{
					option = -165;
					break;
				}
				
				default:
				{
					System.out.println("Choose Option"
							+ "\n1) Edit Profile"
							+ "\n2) Post Study Materials"
							+ "\n3) Show Doubts & Give Answers"
							+ "\n4) View Answered Doubts"
							+ "\n5) Exit");
					option = scan.nextInt();
				}
			}
		}
	}
	
	public void admin(UserDetails user)
	{
		System.out.println("Choose Option"
				+ "\n1) Display All Users"
				+ "\n2) View SignUp Request"
				+ "\n3) View All Questions & ANswers"
				+ "\n4) Exit");
		int option = scan.nextInt();
		
		while(option != -165)
		{
			switch(option)
			{
				case 1:
				{
					try
					{
						Map<String, UserDetails> usersMap = logical.showAllUsers();
						
						for(Map.Entry<String, UserDetails> map : usersMap.entrySet())
						{
							System.out.println(map.getValue());
							System.out.println("------------");
						}
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
					try
					{
						Map<String, UserDetails> usersMap = logical.showAllUsers();
						
						Map<Integer, UserDetails> modifyMap = new HashMap<Integer, UserDetails>();
						
						int i=0;
						for(Map.Entry<String, UserDetails> map : usersMap.entrySet())
						{
							if(map.getValue().getStatus().equalsIgnoreCase("Pending"))
							{
								modifyMap.put(++i, map.getValue());
								System.out.println(i + ") " + map.getValue());
								System.out.println("-----------------------");
							}
						}
						
						System.out.println("Press 1 to Approve/Reject or other key to skip");
						
						if(scan.nextInt() == 1)
						{
							System.out.println("Select User to Approve");
							int action = scan.nextInt();
							
							System.out.println("Press 1 to approve or Other to Reject");
							int app = scan.nextInt();
							
							UserDetails update = new UserDetails();
							update = modifyMap.get(action);
							update.setStatus("APPROVED");
							if(app != 1)
							{
								update.setStatus("REJECTED");
							}
							logical.modifyUser(update);
							System.out.println(update.getStatus() + " SuccessFully");
						}
						option = 0;
						break;
						
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
					Map<Integer, Doubts> answerMap = new HashMap<Integer, Doubts>();
					try
					{
						answerMap = logical.getAnswers();
						
						for(Map.Entry<Integer, Doubts> map : answerMap.entrySet())
						{
							Doubts doubt = map.getValue();
							
							System.out.println("Question: " + doubt.getQuestion());
							System.out.println("Answer: " + doubt.getAnswer() + "\n\n\n");
						}
						
						System.out.println("Press 1 to Delete Question or other key to skip");
						
						if(scan.nextInt() == 1)
						{
							System.out.println("Enter Question Number To Delete");
							int delete = scan.nextInt();
							
							logical.deleteQuestion(delete);
							
							System.out.println("Question Deleted Successfully");
						}
					}
					catch (UserDefinedException ue)
					{
						System.out.println(ue.getMessage());
					}
					option = 0;
					break;
				}
				
				case 4:
				{
					option = -165;
					break;
				}
				
				default:
				{
					System.out.println("Choose Option"
							+ "\n1) Display All Users"
							+ "\n2) View SignUp Request"
							+ "\n3) View All Questions & ANswers"
							+ "\n4) Exit");
					option = scan.nextInt();
				}
			}
		}
	}

}






















