package basic.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Logger;

public class PojoReflectionRunner
{
	public static void main(String[] args) throws Exception
	{
		try(Scanner scan = new Scanner (System.in);)
		{
			Logger logger = Logger.getLogger("Output Statement");
			ReflectionMethods refMethods = new ReflectionMethods();
			int number = 7;
			String inputString = "Hai";
			logger.info("Enter packagename.classname of the class: ");
			String location = scan.next();
			Class<?> classObj = refMethods.getClassObj(location);
//			Class<?> classObj = refMethods.getClassObj("task8.PojoStringAndInteger");
			Constructor<?> defaultCons = refMethods.getDefCons(classObj);
			Object superObj = refMethods.getDefConsObj(defaultCons);
			Constructor<?> overloadedCons = refMethods.getOverCons(classObj, String.class, int.class);
			Object superObj2 = refMethods.getOverConsObj(overloadedCons, inputString, number);
			Method method = refMethods.getMethodsOfClass(classObj, "getInputString");
			System.out.println(refMethods.invokeMethods(method, superObj2).toString());
			method = refMethods.getMethodsOfClass(classObj, "getNumber");
			System.out.println(refMethods.invokeMethods(method, superObj2).toString());
			Method methodObj = refMethods.getMethodsWithParameters(classObj, "setInputString", String.class);
			refMethods.invokeMethodWithParameter(methodObj, superObj, "String value is setted");
			methodObj = refMethods.getMethodsOfClass(classObj, "getInputString");
			System.out.println(refMethods.invokeMethods(methodObj, superObj));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
	}
}