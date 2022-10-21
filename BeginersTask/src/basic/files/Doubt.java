package basic.files;

import myException.UserDefinedException;

public class Doubt {

	public static void main(String[] args) throws UserDefinedException 
	{
		FileTask f = new FileTask();
		System.out.println(f.hashCode());
		FileTask fa = new FileTask();
		System.out.println(fa.hashCode());
		FileTask fb = new FileTask();
		System.out.println(fb.hashCode());
		String s1 = new String("asfag");
		String s2 = new String("aosiudh9ahsdahs");
		System.out.println(s1.hashCode()+ " " + s2.hashCode());
	}

}
