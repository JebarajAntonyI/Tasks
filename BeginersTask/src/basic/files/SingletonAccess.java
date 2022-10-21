package basic.files;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class SingletonAccess 
{

	public static void main(String[] args) throws Exception 
	{
		Class<?> classObj = Class.forName("basic.files.SingletonClass");
		Constructor<?> consObj = classObj.getDeclaredConstructor();
		consObj.setAccessible(true);
		Field fieldObj = classObj.getDeclaredField("access");
		fieldObj.setAccessible(true);
		System.out.println(fieldObj.get(fieldObj));
		fieldObj.set(fieldObj, "I Changed");
		System.out.println(fieldObj.get(fieldObj));
	}

}
