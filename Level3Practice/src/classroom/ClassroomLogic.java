package classroom;

import java.util.HashMap;
import java.util.Map;

import userException.UserDefinedException;

public class ClassroomLogic 
{
	AccessDB access = new AccessDB();
	
	
	public boolean login(String mail, String password) throws UserDefinedException
	{
		Map<String, UserDetails> userMap = new HashMap<>();
		userMap = getSpecificUserDetails(mail);
		UserDetails user = userMap.get(mail);
		
		if(user != null)
		{
			if(user.getPassword().equals(password))
			{
				if(user.getStatus().equalsIgnoreCase("APPROVED"))
				{
					return true;
				}
				throw new UserDefinedException("User Id is Inactive");
			}
			throw new UserDefinedException("Invalid Password");
		}
		throw new UserDefinedException("Invalid UserName");
	}
	
	public Map<String, UserDetails> getSpecificUserDetails(String mail) throws UserDefinedException
	{
		return access.getUserDetails(mail);
	}
	
	public void createUser(UserDetails user) throws UserDefinedException
	{
		access.addUser(user);
	}
	
	public Map<Integer, StudyMaterials> displayMaterials() throws UserDefinedException
	{
		return access.getStudyMaterials();
	}
	
	public void askDoubt(Doubts doubt) throws UserDefinedException
	{
		access.postDoubts(doubt);
	}
	
	public Map<Integer, Doubts> getAnswers() throws UserDefinedException
	{
		return access.getDoubts();
	}
	
	public void provideMaterials(StudyMaterials material) throws UserDefinedException
	{
		access.postMaterials(material);
	}
	
	public Map<Integer, Doubts> displayDoubts() throws UserDefinedException
	{
		return access.getDoubts();
	}
	
	public void giveAnswer(Doubts doubt) throws UserDefinedException
	{
		access.modifyDoubts(doubt);
	}
	
	public Map<String, UserDetails> showAllUsers() throws UserDefinedException
	{
		return access.getUserDetails();
	}
	
	public void modifyUser(UserDetails user) throws UserDefinedException
	{
		access.modifyUserDetails(user);
	}
	
	public void deleteQuestion(int num) throws UserDefinedException
	{
		access.deleteDoubts(num);
	}
}










