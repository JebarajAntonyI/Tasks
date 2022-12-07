package Railways;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable
{
	private int userId;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
