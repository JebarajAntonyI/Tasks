package task8Part2;

import java.lang.reflect.Constructor;

import java.lang.reflect.Method;

public class PojoRunner
{
	public static void main(String[] args) throws Exception
	{
		int number = 7;
		String inputString = "Hai";
		Class<?> c = Class.forName("task8.PojoQ6_7_8");
		Constructor<?> defaultCons = c.getDeclaredConstructor();
		defaultCons.setAccessible(true);
		Object superObj = defaultCons.newInstance();
		Constructor<?> overloadedCons = c.getDeclaredConstructor(String.class, int.class);
		overloadedCons.setAccessible(true);
		Object superObj2 = overloadedCons.newInstance(inputString, number);
		Method method = c.getDeclaredMethod("getInputString");
		System.out.println(method.invoke(superObj2));
		method = c.getDeclaredMethod("getNumber");
		System.out.println(method.invoke(superObj2));
		Method methodObj = c.getDeclaredMethod("setInputString", String.class);
		methodObj.invoke(superObj,"String value is setted");
		methodObj = c.getDeclaredMethod("getInputString");
		System.out.println(methodObj.invoke(superObj));
	}
}