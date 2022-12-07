package arrays2;

import java.util.ArrayList;
import java.util.List;

public class UnionIntersectExcept 
{

	public static void main(String[] args)
	{
		int[] a = {1, 2, 5, 3, 8, 9};
		int[] b = {1, 7, 5, 8, 8};
		
		operation(a, b);
	}
	
	public static void operation(int[] a, int[] b)
	{
		int aLength = a.length;
		int bLength = b.length;
		List<Integer> union = new ArrayList<>();
		List<Integer> except = new ArrayList<>();
		List<Integer> intersect = new ArrayList<>();
		
		for(int i=0; i<aLength; i++)
		{
			if(!union.contains(a[i]))
			{
				union.add(a[i]);
			}
			
			if(a[i]%2 ==  0)
			{
				if(!except.contains(a[i]))
				{
					except.add(a[i]);
				}
			}
		}
		for(int j=0; j<bLength; j++)
		{
			if(!union.contains(b[j]))
			{
				union.add(b[j]);
			}
			
			if(b[j]%2 !=  0)
			{
				if(!except.contains(b[j]))
				{
					except.add(b[j]);
				}
			}
		}
		
		for(int i=0; i<aLength; i++)
		{
			for(int j=0; j<bLength; j++)
			{
				if(a[i] == b[j])
				{
					if(!intersect.contains(b[j]))
					{
						intersect.add(b[j]);
					}
				}
			}
		}
		
		System.out.println("Union: " + union);
		System.out.println("Except: " + except);
		System.out.println("Intersect: " + intersect);
	}

}
