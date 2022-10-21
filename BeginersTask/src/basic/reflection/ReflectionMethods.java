package basic.reflection;

import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethods 
{
	public Class<?> getClassObj(String classLocation) throws ClassNotFoundException
	{
		return Class.forName(classLocation);
	}
	
	public Constructor<?> getDefCons(Class<?> classObj) throws NoSuchMethodException, SecurityException
	{
		return classObj.getDeclaredConstructor();
	}
	
	public Constructor<?> getOverCons(Class<?> classObj, Class<String> classStr, Class<Integer> classInt) throws NoSuchMethodException, SecurityException
	{
		return classObj.getDeclaredConstructor(classStr, classInt);
	}
	
	public Object getDefConsObj(Constructor<?> consObj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		return consObj.newInstance();
	}
	
	public Object getOverConsObj(Constructor<?> consObj, String inputString, int number) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		return consObj.newInstance(inputString, number);
	}
	
	public Method getMethodsOfClass(Class<?> classObj, String methodName) throws NoSuchMethodException, SecurityException
	{
		return classObj.getDeclaredMethod(methodName);
	}
	
	public Object invokeMethods(Method methodObj, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		return methodObj.invoke(obj);
	}
	
	public Method getMethodsWithParameters(Class<?> classObj, String methodName, Class<String> stringObj) throws NoSuchMethodException, SecurityException
	{
		return classObj.getDeclaredMethod(methodName, stringObj);
	}
	
	public String invokeMethodWithParameter(Method methodObj, Object obj, String inputString) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		return (String) methodObj.invoke(obj, inputString);
	}
}


























