package foodorder;

public class Customer 
{
	public Customer()
	{
		
	}
	
	public Customer(String name, int age, String email, String password, long mobile)
	{
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	
	private String name;
	private int age;
	private String email;
	private String password;
	private long mobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
