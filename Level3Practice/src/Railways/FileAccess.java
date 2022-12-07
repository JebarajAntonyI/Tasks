package Railways;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileAccess 
{
	public <K, V> void writeFile(String path, Map<K, V> map) throws IOException
	{
		try(FileOutputStream file = new FileOutputStream(path))
		{
			try(ObjectOutputStream out = new ObjectOutputStream(file))
			{
				out.writeObject(map);
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public <K, V> Map<K, V> readFile(String path) throws IOException, ClassNotFoundException
	{
		try(FileInputStream file = new FileInputStream(path))
		{
			try(ObjectInputStream in = new ObjectInputStream(file))
			{
				return (Map<K, V>) in.readObject();
			}
		}
	}
	
	public <K, V> void fillTrainDetails(String path, Map<String, Map<Long, Train>> dateMap) throws IOException
	{
		try(FileOutputStream file = new FileOutputStream(path))
		{
			try(ObjectOutputStream out = new ObjectOutputStream(file))
			{
				out.writeObject(dateMap);
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public <K, V> Map<String, Map<Long, Train>> readTrainDetails(String path) throws IOException, ClassNotFoundException
	{
		try(FileInputStream file = new FileInputStream(path))
		{
			try(ObjectInputStream in = new ObjectInputStream(file))
			{
				return (Map<String, Map<Long, Train>>) in.readObject();
			}
		}
		catch(FileNotFoundException ce)
		{
			Map<String, Map<Long, Train>> dateMap = new HashMap<String, Map<Long,Train>>();
			fillTrainDetails(path, dateMap);
			
			try(FileInputStream file = new FileInputStream(path))
			{
				try(ObjectInputStream in = new ObjectInputStream(file))
				{
					return (Map<String, Map<Long, Train>>) in.readObject();
				}
			}
		}
	}
}
