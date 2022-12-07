package onlinejob;

import java.util.HashMap;
import java.util.Map;

import userException.UserDefinedException;

public class JobLogic 
{
	UserStorage cach = new UserStorage();
	Map<String, Applicant> applicantMap = new HashMap<String, Applicant>();
	Map<String, Company> companyMap = new HashMap<String, Company>();
	Map<String, String> jobMap = new HashMap<String, String>();
	Map<String, Map<String, String>> appliedJob = new HashMap<String, Map<String, String>>();
	
	public boolean applicantLogin(String userName, String password)
	{
		applicantMap = cach.getApplicantMap();
		
		Applicant applicant = applicantMap.get(userName);
		
		if(applicant != null)
		{
			if(applicant.getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean applicantRegistration(Applicant applicant)
	{
		applicantMap = cach.getApplicantMap();
		
		if(applicantMap.get(applicant.getUserName()) == null)
		{
			applicantMap.put(applicant.getUserName(), applicant);
			return true;
		}
		return false;
	}
	
	public boolean adminLogin(String userName, String password)
	{
		companyMap = cach.getCompanyMap();
		
		Company admin = companyMap.get(userName);
		
		if(admin != null)
		{
			if(admin.getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean adminRegistration(Company admin)
	{
		companyMap = cach.getCompanyMap();
		
		if(companyMap.get(admin.getUserName()) == null)
		{
			companyMap.put(admin.getUserName(), admin);
			return true;
		}
		return false;
	}
	
	public void applyJob(String UserName, String JobTitle, String jobMessage)
	{
//		jobMap = cach.getJobMap();
		appliedJob = cach.getAppliedJob();
		
		Map<String, String> user = appliedJob.get(UserName);
		if(user == null)
		{
			user = new HashMap<String, String>();
		}
		
		user.put(JobTitle, jobMessage);
		appliedJob.put(UserName, user);
	}
	
	public Map<String, String> viewAppliedJob(String UserName) throws UserDefinedException
	{
		appliedJob = cach.getAppliedJob();
		
		Map<String, String> user = appliedJob.get(UserName);
		
		
		if(user != null)
		{
			return user;
		}
		throw new UserDefinedException("Not Applied For Any Jobs");
	}
	
	public Map<String, Map<String, String>> viewAllAppliedJob() throws UserDefinedException
	{
		appliedJob = cach.getAppliedJob();
		
		if(appliedJob != null)
		{
			return appliedJob;
		}
		throw new UserDefinedException("Not Applied For Any Jobs");
	}

}












