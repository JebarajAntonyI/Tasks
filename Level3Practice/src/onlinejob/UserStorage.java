package onlinejob;

import java.util.HashMap;
import java.util.Map;

public class UserStorage 
{
	public UserStorage()
	{
		initialise();
	}
	
	static Map<String, Applicant> applicantMap = new HashMap<String, Applicant>();
	static Map<String, Company> companyMap = new HashMap<String, Company>();
	static Map<String, String> jobMap = new HashMap<String, String>();
	static Map<String, Map<String, String>> appliedJob = new HashMap<String, Map<String, String>>();
	

	public Map<String, Map<String, String>> getAppliedJob() {
		return appliedJob;
	}

	public Map<String, String> getJobMap() {
		return jobMap;
	}

	public void initialise()
	{
		Applicant applicant = new Applicant();
		applicant.setName("Viswa");
		applicant.setEmail("viswa@gmail.com");
		applicant.setMobile(8266478558L);
		applicant.setUserName("viswa");
		applicant.setPassword("12345");
		applicant.setRoll("Software Developer");
		applicantMap.put(applicant.getUserName(), applicant);
		
		Company admin = new Company();
		admin.setName("Deva");
		admin.setEmail("deva@gmail.com");
		admin.setMobile(8456321598L);
		admin.setUserName("deva");
		admin.setPassword("54321");
		companyMap.put(admin.getUserName(), admin);
		
		jobMap.put("Software Developer", "Required 15 Developers with Good Knowledge in JAVA...Location Chennai...");
		jobMap.put("Testing Engineers", "10 vaccancies for Testing Engineers with minimum 2 years Experience...Location Madurai...");
		jobMap.put("Game Developer", "Required 7 Developers with Good Knowledge in Gaming Creativity...Location Banglore...");
	}
	
	public Map<String, Applicant> getApplicantMap() {
		return applicantMap;
	}

	public Map<String, Company> getCompanyMap() {
		return companyMap;
	}

}
