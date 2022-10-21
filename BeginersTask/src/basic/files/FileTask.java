package basic.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import myException.InputValidityCheck;
import myException.UserDefinedException;

public class FileTask 
{
	
//EX1
	public void writeFile(String path, String... writeString) throws UserDefinedException, IOException
	{	
		InputValidityCheck.checkNull(writeString);
		try (OutputStream outputStream = new FileOutputStream(path))
		{
			int size = writeString.length;																//swami - Resolved
			for (int i=0; i < size; i++)
			{
				byte[] b1 = (writeString[i] + "\n").getBytes();
				outputStream.write(b1);
			}
		}
		catch (IOException ie)
		{
			throw new IOException ("IO-Exception occured");
		}
	}
		
//EX2
	public void filePropertiesStore (String path, Properties properties) throws UserDefinedException, IOException
	{
		InputValidityCheck.checkNull(properties);
		try (OutputStream outputStream = new FileOutputStream(path))
		{
			properties.store(outputStream, "Properties stored");										//swami - Resolved
		}
		catch (IOException ie)
		{
			throw new IOException ("IO-Exception occured");
		}
	}
	
//EX3
	public void returnProperties (String path, Properties properties) throws UserDefinedException, IOException 
	{
		InputValidityCheck.checkNull(properties);														//swami - Resolved
		try (InputStream inputStream = new FileInputStream(path))
		{
			properties.load(inputStream);
		}
		catch (IOException ie)
		{
			throw new IOException ("IO-Exception occured");
		}
	}
	
//	EX4
	public boolean makeDirectorty(String dir)
	{
		File newFile = new File(dir);
		return newFile.mkdir();
	}
}






















