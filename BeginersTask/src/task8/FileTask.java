package task8;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.util.Properties;

import myException.UserDefinedException;

public class FileTask 
{
	
//EX1
	public void writeFile(OutputStream os, String writeString) throws UserDefinedException, IOException
	{	
		
			byte[] b1 = (writeString + "\n").getBytes();
			os.write(b1);
	}
		
//EX2
	public void filePropertiesAdd (Properties p, OutputStream os, String keyString, String valueString) throws UserDefinedException
	{
		p.setProperty(keyString, valueString);
	}
	
	public void storeProperty (OutputStream os, Properties p) throws UserDefinedException, IOException
	{
		p.store(os, "Properties stored");
	}
	
//EX3
	public void returnProperties (String path, Properties p) throws UserDefinedException, IOException 
	{
		InputStream is = new FileInputStream(path);
		p.load(is);
	}
	
	
}






















