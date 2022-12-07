package Railways;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Details implements Serializable
{
	private int userId;
	private String name;
	private long pnr;
	private int age;
	private String sex;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String toString()
	{
		return "UserId: " + userId
				+ "\nPNR: " + pnr
				+ "\nName: " + name
				+ "\nAge: " + age
				+ "\nSex: " + sex;
	}
}
