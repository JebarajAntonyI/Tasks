package task9;

public class RunnableThread6 implements Runnable
{
	private int value = 77;
	public void setValue(int value) 
	{
		this.value = value;
	}
	public void run()
	{
		while (value != 0)
		{
			System.out.println("RunnableThread is Running..... \n");
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
