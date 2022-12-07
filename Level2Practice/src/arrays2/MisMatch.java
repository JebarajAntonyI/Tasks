package arrays2;

import java.util.HashMap;
import java.util.Map;

public class MisMatch 
{

	public static void main(String[] args) 
	{
		char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		char[] b = {'a', 'b', 'd', 'e', 'e', 'g', 'g', 'i', 'i'};
		
		Map<String, String> map = different(a, b);
		
		if(!map.isEmpty()) 
		{
			for(Map.Entry<String, String> m: map.entrySet())
			{
				System.out.print(m.getKey() + "," + m.getValue() + " ");
			}
		}
	}
	
	public static Map<String, String> different(char[] a, char[] b)
	{
		String aString = "";
		String bString = "";
//		List<String> aList = new ArrayList<>();
//		List<String> bList = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		
		int aLength = a.length;
		int bLength = b.length;
		
		if(aLength != bLength)
		{
			
		}
		
		for(int i=0; i<aLength; i++)
		{
			if(a[i] != b[i])
			{
				aString = aString + a[i];
				bString = bString + b[i];
			}
			else if(aString.length() > 0)
			{
//				aList.add(aString);
//				bList.add(bString);
				map.put(aString, bString);
				
				aString = "";
				bString = "";
			}
		}
		return map;
	}

}
