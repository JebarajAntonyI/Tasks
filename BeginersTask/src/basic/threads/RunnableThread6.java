package basic.threads;

public class RunnableThread6 implements Runnable
{
	private String name;
	
	public RunnableThread6 (String name)
	{
		this.name = name;
	}
	
	private int value = 77;
	public void setValue(int value) 
	{
		this.value = value;
	}
	public void run()
	{
		Thread.currentThread().setName(name);
		while (value != 0)
		{
			System.out.println("RunnableThread " + name + " is Running..... \n");
			try 
			{
				Thread.sleep(4000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			value--;
		}
	}

}
