package string3;

import java.util.regex.Pattern;

public class Decode {

	public static void main(String[] args) 
	{
		String input = "3A2(ABC)3D";
		StringBuilder text = new StringBuilder();
		StringBuilder num = new StringBuilder();
//		List<Integer> numList = new ArrayList<>();
		
		int length = input.length();
		for(int i=0; i<length; i++)
		{
			char ch = input.charAt(i);
			
			if(Pattern.matches("[a-zA-Z]", String.valueOf(ch)));
			{
				text.append(String.valueOf(ch));
				if(num.length() != 0)
				{
					
				}
			}
		}
	}

}
