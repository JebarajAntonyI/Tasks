package basic.files;

import myException.UserDefinedException;

public class Doubt2 {

	public static void main(String[] args) throws UserDefinedException, InterruptedException 
	{
		boolean v = true;
		FileTask f2 = new FileTask();
		System.out.println(f2.hashCode());
		SingletonClass s2 = SingletonClass.getInstance();
		while (v)
		{
			System.out.println(s2.hashCode());
			Thread.sleep(30000);
			System.out.println(s2.hashCode());
			v = false;
		}
	}

}
